package com.furkan.rabbitmq.messagemodel;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageModelSavePassenger implements Serializable {
    private String username;
    private String name;
    private String surname;
    private String email;
    private Long authId;
}
