package org.example.mediator.model;

import lombok.*;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class Payment {

    int orderId;
    int paymentId;
    double totalPrice;
    boolean paymentMade;
}
