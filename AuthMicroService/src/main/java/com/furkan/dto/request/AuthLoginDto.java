package com.furkan.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthLoginDto {
    private String username;
    private String password;
}
