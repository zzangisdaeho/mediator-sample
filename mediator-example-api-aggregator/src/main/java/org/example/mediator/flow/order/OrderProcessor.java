package org.example.mediator.flow.order;

import lombok.extern.slf4j.Slf4j;
import org.example.mediator.model.Payment;
import org.example.mediator.model.PurchaseOrder;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project : mediator-example-item-service
 * Created by : IntelliJ IDEA
 * Developer : ymkim
 */
@Component
@Slf4j
public class OrderProcessor {

    @Splitter(inputChannel = "order.search.split", outputChannel = "order.search.route")
    public List<SearchSegment> splitOrderSearch(int orderId) {
        List<SearchSegment> list = new ArrayList<SearchSegment>();

        // order 검색
        list.add(SearchSegment.builder().id(orderId).type("order").build());

        // payment 검색
        list.add(SearchSegment.builder().id(orderId).type("payment").build());

        return list;
    }

    @Router(inputChannel = "order.search.route")
    public String routeOrderSearch(SearchSegment payload) {

        if ("order".equals(payload.getType())) {
            return "order.detail.outbound.request";
        }
        else if ("payment".equals(payload.getType())) {
            return "payment.detail.outbound.request";
        }
        else {
            return "error.order.search";
        }
    }

    @Aggregator(inputChannel = "order.search.aggregate", outputChannel = "order.detail.get.response")
    public Object aggregateOrderSearch(List<Message<?>> messages) {

        Map<String, Object> resultMap = new HashMap<>();

        for ( Message message: messages) {
          //
            if (message.getPayload() instanceof List) {
                resultMap.put("payment", (message.getPayload()));
            }
            else if (message.getPayload() instanceof PurchaseOrder) {
                resultMap.put("order", message.getPayload());
            }
        }
        return resultMap;
    }

}
