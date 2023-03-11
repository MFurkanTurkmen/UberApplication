package com.furkan.service;

import com.furkan.dto.request.AuthSaveDto;
import com.furkan.mapper.IAuthMapper;
import com.furkan.repository.IAuthRepository;
import com.furkan.repository.entity.Auth;
import com.furkan.utility.ServiceManagerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

@Service
public class AuthService extends ServiceManagerImpl<Auth,Long> {
    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository=authRepository;
    }

    public void save(AuthSaveDto dto){
        Auth auth=IAuthMapper.INSTANCE.toAuth(dto);
        if (auth.getName()==null||auth.getUsername()==null||auth.getEmail()==null ||auth.getUsername()=="")
            throw new ServerErrorException("hata aldık... auth service... save metodu");
        save(auth);
    }
}
