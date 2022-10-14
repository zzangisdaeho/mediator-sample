package org.example.mediator.controller;

import lombok.RequiredArgsConstructor;
import org.example.mediator.model.Payment;
import org.example.mediator.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> findByOrderId(@RequestParam("orderId") int orderId) {
        return paymentService.findByOrderId(orderId);
    }

    @GetMapping("/{paymentId}")
    public Payment findById(@PathVariable("paymentId") int paymentId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.findById(paymentId);

    }

}