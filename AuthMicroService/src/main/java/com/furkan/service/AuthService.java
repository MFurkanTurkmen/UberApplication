package com.furkan.service;

import com.furkan.dto.request.AuthSaveDto;
import com.furkan.mapper.IAuthMapper;
import com.furkan.rabbitmq.messagemodel.MessageModelSaveDriver;
import com.furkan.rabbitmq.producer.ProducerSaveDriver;
import com.furkan.repository.IAuthRepository;
import com.furkan.repository.entity.Auth;
import com.furkan.repository.entity.Type;
import com.furkan.utility.ServiceManagerImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManagerImpl<Auth,Long> {
    private final IAuthRepository authRepository;
    private final ProducerSaveDriver producerSaveDriver;

    public AuthService(IAuthRepository authRepository, ProducerSaveDriver producerSaveDriver) {
        super(authRepository);
        this.authRepository=authRepository;
        this.producerSaveDriver = producerSaveDriver;
    }

    public void save(AuthSaveDto dto){
        Auth auth=IAuthMapper.INSTANCE.toAuth(dto);
        save(auth);
        if (auth.getType()== Type.DRIVER){
        producerSaveDriver.sendMessageSaveDriver(MessageModelSaveDriver.builder()
                        .authId(auth.getId())
                        .name(auth.getName())
                        .surname(auth.getSurname())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                .build());
        }
        else if( auth.getType()==Type.PASSENGER){

        }
    }
}
