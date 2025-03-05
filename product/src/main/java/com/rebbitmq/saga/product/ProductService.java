package com.rebbitmq.saga.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : hanjihoon
 * @Date : 2025. 03. 06.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${message.queue.payment}")
    private String paymentQueue;

    public void reduceProductAmount(DeliveryMessage deliveryMessage) {
        Integer productId = deliveryMessage.getProductId();
        Integer productQuantity = deliveryMessage.getProductQuantity();

        if (productId != 1 && productQuantity > 1) {
            return;
        }

        rabbitTemplate.convertAndSend(paymentQueue, deliveryMessage);
    }

}
