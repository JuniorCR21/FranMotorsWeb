package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("{spring.mail.username}")
    private String username;
    
    @Override
    public void sendEmail(String subject, String text, String toUser) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom(username);
        message.setTo(toUser);
        message.setSubject(subject);
        message.setText(text);
        
        mailSender.send(message);
    }

}
