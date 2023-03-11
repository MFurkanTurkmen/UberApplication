package com.furkan.rabbitmq.messagemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageModelSaveUser {
    private String username;
    private String name;
    private String surname;
    private String email;
    private Long authId;
}
