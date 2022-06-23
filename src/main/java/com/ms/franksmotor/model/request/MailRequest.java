package com.ms.franksmotor.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailRequest {

    private String subject;
    
    private String text;
    
    private String toUser;
    
    private String name;
    
}
