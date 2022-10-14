package org.exmple.mediator.controller;

import lombok.RequiredArgsConstructor;
import org.exmple.mediator.model.PurchaseOrder;
import org.exmple.mediator.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @GetMapping("/{orderId}")
    public PurchaseOrder findById(@PathVariable("orderId") int orderId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return purchaseOrderService.findById(orderId);
    }
}
