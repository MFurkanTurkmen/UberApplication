package com.furkan.controller;


import com.furkan.dto.request.AuthLoginDto;
import com.furkan.dto.request.AuthSaveDto;
import com.furkan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth-save")
    public ResponseEntity<String> createAuth(@RequestBody AuthSaveDto dto){
        authService.save(dto);
        return ResponseEntity.ok("kullanici kayıt edildi.");
    }


    @PostMapping("/login")
    public ResponseEntity<String> doLogin(@RequestBody AuthLoginDto dto){
        return ResponseEntity.ok(authService.doLogin(dto));
    }
    @PostMapping("/mesaj-gönder")
    public ResponseEntity<String> fanoutDeneme(@RequestBody String mesaj){
        authService.fanoutDeneme(mesaj);
        return ResponseEntity.ok("mesaj gönderildi");
    }
    @GetMapping("/gatewaymesaj")
    public ResponseEntity<String> gatewayMessageDeneme( String mesajj){
        return ResponseEntity.ok(authService.apideneme(mesajj));
    }

}
