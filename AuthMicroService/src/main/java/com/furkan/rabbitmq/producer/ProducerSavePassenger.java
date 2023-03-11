package com.furkan.rabbitmq.producer;

import com.furkan.rabbitmq.messagemodel.MessageModelSavePassenger;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerSavePassenger {
    private final RabbitTemplate rabbitTemplate;
    public void sendMessageSavePassenger(MessageModelSavePassenger modelSavePassenger){
        rabbitTemplate.convertAndSend("exchange-direct-auth","binding-key-auth",modelSavePassenger);
    }

}
