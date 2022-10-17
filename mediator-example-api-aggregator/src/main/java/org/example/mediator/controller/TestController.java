package org.example.mediator.flow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestGateway testGateway;

    @GetMapping("/wtf/{orderId}")
    public Map test1(@PathVariable int orderId){
        Map<String, Object> stringObjectMap = testGateway.aggregateTest(orderId);
        return stringObjectMap;
    }
}
