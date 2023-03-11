package com.furkan.service;

import com.furkan.mapper.IDriverMapper;
import com.furkan.rabbitmq.consumer.ConsumerDriverSave;
import com.furkan.rabbitmq.messagemodel.MessageModelSaveDriver;
import com.furkan.repository.IDriverRepository;
import com.furkan.repository.entity.Driver;
import com.furkan.utility.ServiceManagerImpl;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends ServiceManagerImpl<Driver,Long> {

    private final IDriverRepository driverRepository;
    public DriverService(IDriverRepository driverRepository) {
        super(driverRepository);
        this.driverRepository = driverRepository;
    }

    public void save(MessageModelSaveDriver modelSaveDriver){
        Driver driver=IDriverMapper.INSTANCE.toDriver(modelSaveDriver);
        save(driver);
    }
}
