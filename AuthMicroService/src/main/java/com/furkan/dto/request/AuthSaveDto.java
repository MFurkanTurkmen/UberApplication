package com.furkan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthSaveDto {
    private String username;
    private String name;
    private String surname;
    private String password;
    private String email;
}
