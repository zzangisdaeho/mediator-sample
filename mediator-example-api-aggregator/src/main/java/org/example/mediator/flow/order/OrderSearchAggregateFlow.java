package org.example.mediator.flow.order;

import org.example.mediator.model.Payment;
import org.example.mediator.model.PurchaseOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;

import java.util.List;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@Configuration
public class OrderSearchAggregateFlow {

    @Bean("order.get.flow")
    public IntegrationFlow orderGetFlow() {

        return IntegrationFlows
                .from(
                        Http.inboundGateway("orders/{orderId}")
                        .requestMapping( r -> r.methods(HttpMethod.GET))
                        .payloadExpression("#pathVariables.orderId")
                        .replyChannel("order.detail.get.response")

                )
                .channel("order.search.split")
                .get();
    }

    @Bean("order.detail.get.response")
    public DirectChannel orderDetailResponseChannel() {
        return new DirectChannel();
    }

    @Bean("order.get.outbound.flow")
    public IntegrationFlow orderOutboundSearch() {

        return IntegrationFlows.from("order.detail.outbound.request")
                .handle(Http.outboundGateway("http://localhost:9090/orders/{orderId}").charset("UTF-8")
                        .uriVariable("orderId", "payload.id")
                        .httpMethod(HttpMethod.GET)
                        .expectedResponseType(PurchaseOrder.class))
                .channel("order.search.aggregate")
                .get();
    }

    @Bean("purchase.get.outbound.flow")
    public IntegrationFlow paymentOutboundSearch() {

        return IntegrationFlows.from("payment.detail.outbound.request")
                .handle(Http.outboundGateway("http://localhost:9100/payments?orderId={orderId}").charset("UTF-8")
                        .uriVariable("orderId", "payload.id")
                        .httpMethod(HttpMethod.GET)
                        .expectedResponseType(List.class))
                .channel("order.search.aggregate")
                .get();
    }
}
