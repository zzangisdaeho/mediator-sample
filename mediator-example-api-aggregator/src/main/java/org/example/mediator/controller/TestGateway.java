package org.example.mediator.controller;

import org.springframework.integration.annotation.MessagingGateway;

import java.util.Map;

@MessagingGateway(defaultRequestChannel="order.search.split", defaultReplyChannel = "order.detail.get.response")
public interface TestGateway {

    Map<String, Object> aggregateTest(int orderId);
}
