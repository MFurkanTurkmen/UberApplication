package com.furkan.rabbitmq.consumer;

import com.furkan.rabbitmq.messagemodel.MessageModelSavePassenger;
import com.furkan.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerPassengerSave {
    private final PassengerService driverService;

    @RabbitListener(queues = "queue-create-passenger")
    public void listenerSaveDriver(MessageModelSavePassenger modelSaveDriver){
        driverService.save(modelSaveDriver);
    }
}
