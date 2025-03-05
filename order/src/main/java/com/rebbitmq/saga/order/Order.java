package com.rebbitmq.saga.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author : hanjihoon
 * @Date : 2025. 03. 06.
 */
@Builder
@Data
@ToString
public class Order {

    private UUID orderId;

    private String userId;
    private String orderStatus;
    private String errorType;

    public void cancelOrder(String receiveErrorType) {
        orderStatus = "CANCEL";
        errorType = receiveErrorType;
    }

}
