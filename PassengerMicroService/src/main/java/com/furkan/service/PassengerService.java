package com.furkan.service;

import com.furkan.mapper.IPassengerMapper;
import com.furkan.rabbitmq.messagemodel.MessageModelSavePassenger;
import com.furkan.repository.IPassengerRepository;
import com.furkan.repository.entity.Passenger;
import com.furkan.utility.ServiceManagerImpl;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends ServiceManagerImpl<Passenger,Long> {

    private final IPassengerRepository passengerRepository;
    public PassengerService(IPassengerRepository passengerRepository) {
        super(passengerRepository);
        this.passengerRepository = passengerRepository;
    }

    public void save(MessageModelSavePassenger modelSavePassenger){
        Passenger passenger= IPassengerMapper.INSTANCE.toDriver(modelSavePassenger);
        save(passenger);
    }
}
