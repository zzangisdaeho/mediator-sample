package org.example.mediator.service;

import org.example.mediator.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@Service
public class PaymentService {

    public List<Payment> findByOrderId(int orderId) {
        List<Payment> payments = new ArrayList<>();
        payments.add(
                Payment.builder()
                        .paymentMade(true)
                        .orderId(orderId)
                        .paymentId(10 + orderId)
                        .totalPrice(99999999999.9)
                        .build()
        );
        return payments;
    }

    public Payment findById(int paymentId) {
        return Payment.builder()
                .paymentMade(true)
                .orderId(paymentId-10)
                .paymentId(paymentId)
                .totalPrice(99999999999.9)
                .build();
    }
}
