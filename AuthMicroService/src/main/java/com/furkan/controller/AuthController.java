package com.furkan.controller;


import com.furkan.dto.request.AuthSaveDto;
import com.furkan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/Auth-Save")
    public ResponseEntity<String> createAuth(@RequestBody AuthSaveDto dto){
        authService.save(dto);
        return ResponseEntity.ok("kullanici kayıt edildi.");
    }
}
