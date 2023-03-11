package com.furkan.rabbitmq.producer;

import com.furkan.rabbitmq.messagemodel.MessageModelSaveDriver;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerSaveDriver {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessageSaveDriver(MessageModelSaveDriver modelSaveDriver){
        rabbitTemplate.convertAndSend("exchange-direct-auth","binding-key-auth",modelSaveDriver);
    }
}
