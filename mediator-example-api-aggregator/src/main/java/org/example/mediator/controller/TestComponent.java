package org.example.mediator.flow.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestComponent {

//    @ServiceActivator(inputChannel = "order.detail.get.response")
//    @Bean
//    public HttpRequestExecutingMessageHandler outbound() {
//        System.out.println("true = " + true);
//        HttpRequestExecutingMessageHandler handler =
//                new HttpRequestExecutingMessageHandler("http://localhost:9110/wtf");
//        handler.setHttpMethod(HttpMethod.GET);
//        handler.setExpectedResponseType(Object.class);
//        return handler;
//    }

//    @Bean
//    public HttpRequestHandlingMessagingGateway inbound() {
//        System.out.println("true = " + true);
//        HttpRequestHandlingMessagingGateway gateway =
//                new HttpRequestHandlingMessagingGateway(true);
//        gateway.setRequestMapping(mapping());
////        gateway.setRequestPayloadType();
//        gateway.setRequestChannelName("order.detail.get.response");
//        return gateway;
//    }
//
//    public RequestMapping mapping() {
//        RequestMapping requestMapping = new RequestMapping();
//        requestMapping.setPathPatterns("/wtf");
//        requestMapping.setMethods(HttpMethod.GET);
//        return requestMapping;
//    }


}
