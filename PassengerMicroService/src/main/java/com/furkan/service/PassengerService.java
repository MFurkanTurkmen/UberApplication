package com.furkan.service;

import com.furkan.mapper.IPassengerMapper;
import com.furkan.rabbitmq.messagemodel.ModelFanout;
import com.furkan.rabbitmq.messagemodel.ModelSave;
import com.furkan.repository.IPassengerRepository;
import com.furkan.repository.entity.Passenger;
import com.furkan.utility.ServiceManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends ServiceManagerImpl<Passenger,Long> {

    @Autowired
    private final IPassengerRepository passengerRepository;
    public PassengerService(IPassengerRepository passengerRepository) {
        super(passengerRepository);
        this.passengerRepository = passengerRepository;
    }

    public void save(ModelSave modelSavePassenger){
        Passenger passenger= IPassengerMapper.INSTANCE.toDriver(modelSavePassenger);
        save(passenger);
    }

    public void getMessage(ModelFanout fanout){
        System.out.println("passenger servise ici ,fanout dan şu mesaj geldi...: "+fanout.toString());
    }
}
