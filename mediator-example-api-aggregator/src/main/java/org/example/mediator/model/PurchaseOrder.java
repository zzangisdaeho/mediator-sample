package org.example.mediator.model;

import lombok.*;

import java.util.List;

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
public class PurchaseOrder {

    private int orderId;
    private List<Integer> itemIds;
}
