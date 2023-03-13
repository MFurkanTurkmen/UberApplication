package com.furkan.service;

import com.furkan.dto.request.AuthLoginDto;
import com.furkan.dto.request.AuthSaveDto;
import com.furkan.mapper.IAuthMapper;
import com.furkan.rabbitmq.messagemodel.ModelFanout;
import com.furkan.rabbitmq.messagemodel.ModelSave;
import com.furkan.rabbitmq.producer.ProducerFanoutMessage;
import com.furkan.rabbitmq.producer.ProducerDirectSave;
import com.furkan.repository.IAuthRepository;
import com.furkan.repository.entity.Auth;
import com.furkan.repository.entity.Type;
import com.furkan.utility.JwtTokenManager;
import com.furkan.utility.ServiceManagerImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManagerImpl<Auth,Long> {
    private final IAuthRepository authRepository;
    private final ProducerDirectSave producerDirectSave;
    private final ProducerFanoutMessage producerFanoutMessage;
    private final JwtTokenManager jwtTokenManager;

    public AuthService(IAuthRepository authRepository, ProducerDirectSave producerDirectSave, ProducerFanoutMessage producerFanoutMessage, JwtTokenManager jwtTokenManager) {
        super(authRepository);
        this.authRepository=authRepository;
        this.producerDirectSave = producerDirectSave;
        this.producerFanoutMessage = producerFanoutMessage;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void save(AuthSaveDto dto){
        Auth auth=IAuthMapper.INSTANCE.toAuth(dto);
        save(auth);
        if (auth.getType()== Type.DRIVER){
            producerDirectSave.sendMessageSaveDriver(ModelSave.builder()
                        .authId(auth.getId())
                        .name(auth.getName())
                        .surname(auth.getSurname())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                .build());
        }
        else if( auth.getType()==Type.PASSENGER){
            producerDirectSave.sendMessageSavePassenger(ModelSave.builder()
                        .authId(auth.getId())
                        .username(auth.getUsername())
                        .email(auth.getEmail())
                        .name(auth.getName())
                        .surname(auth.getSurname())
                .build());
        }
    }

    public String doLogin(AuthLoginDto dto){
        Optional<Auth> auth =  authRepository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if(auth.isEmpty()) System.out.println("auth bos geldi");
            //throw new AuthException(EErrorType.AUTH_LOGIN_ERROR);
        Optional<String> token = jwtTokenManager.createToken(auth.get().getId());
        if(token.isEmpty()) System.out.println("token bos geldi");
           // throw new AuthException(EErrorType.TOKEN_ERROR);
        return token.get();
    }




    public void  fanoutDeneme(String mesaj){
        producerFanoutMessage.sendFanoutMessage(ModelFanout.builder()
                        .mesaj(mesaj)
                .build());
    }

    public String apideneme(String mesaj){
        return "disardan aldigimiz mesajı service icinde bu yazının sonuna ekledik: "+mesaj;
    }



}
