package org.example.mediator.flow.payment;

import org.example.mediator.model.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@Configuration
public class SimplePaymentSearchFlow {

    @Bean("payment.get.flow")
    public IntegrationFlow paymentGetFlow() {

        return IntegrationFlows
                .from(
                        Http.inboundGateway("payments/{paymentId}")
                        .requestMapping( r -> r.methods(HttpMethod.GET))
                        .payloadExpression("#pathVariables.paymentId")

                )
                .channel("payment.get.outbound.request")
                .get();
    }

    @Bean("payment.get.outbound.request")
    public DirectChannel paymentOutboundRequestChannel() {
        return new DirectChannel();
    }

    @Bean("payment.get.outbound.flow")
    public IntegrationFlow httpOut() {

        return IntegrationFlows.from("payment.get.outbound.request")
                .handle(Http.outboundGateway("http://localhost:9100/payments/{paymentId}").charset("UTF-8")
                        .uriVariable("paymentId", "payload")
                        .httpMethod(HttpMethod.GET)
                        .expectedResponseType(Payment.class))
                .get();
    }
}
