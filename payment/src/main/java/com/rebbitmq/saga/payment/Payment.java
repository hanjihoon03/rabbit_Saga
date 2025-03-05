package com.rebbitmq.saga.payment;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

/**
 * @author : hanjihoon
 * @Date : 2025. 03. 06.
 */
@Data
@Builder
public class Payment {

    private UUID paymentId;
    private String userId;

    private Integer payAmount;
    private String payStatus;

}
