package com.rebbitmq.saga.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : hanjihoon
 * @Date : 2025. 03. 06.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEndpoint {

    private final PaymentService paymentService;

    @RabbitListener(queues = "${message.queue.payment}")
    public void receiveMessage(DeliveryMessage deliveryMessage) {
        log.info("PAYMENT MESSAGE: {}", deliveryMessage);
        paymentService.createPayment(deliveryMessage);
    }

}
