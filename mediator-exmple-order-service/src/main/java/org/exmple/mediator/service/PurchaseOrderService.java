package org.exmple.mediator.service;

import org.exmple.mediator.model.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@Service
public class PurchaseOrderService {

    public PurchaseOrder findById(int id) {

        return dummyPurchaseOrder(id);
    }

    private PurchaseOrder dummyPurchaseOrder(int id) {

        List<Integer> itemIds = new ArrayList<>();
        for (int i=1; i<11; i++) {
            itemIds.add(i);
        }

        return PurchaseOrder.builder()
                .orderId(id)
                .itemIds(itemIds).build();
    }
}
