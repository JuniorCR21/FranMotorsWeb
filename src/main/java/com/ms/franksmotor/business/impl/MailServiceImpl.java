package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.MailService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Value("{spring.mail.username}")
    private String username;
    
    @Override
    public void sendEmail(String subject, String text, String name, String toUser) {
        
        StringBuilder content = new StringBuilder();
        content.append("<img src='https://cdn-icons-png.flaticon.com/512/2345/2345548.png' width=50px />");
        content.append("<h2 style='color:#000; margin-top:6px; padding: 4px'>Hola " + name + "</h2>");
        content.append("<h3 style='background:#058CC6; color:#fff; padding: 4px'>" + text + "</h3>");
        MimeMessage message =mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
            helper.setTo(toUser);
            helper.setSubject(subject);
            message.setFrom(username);
            message.setContent(content.toString(), "text/html");
            mailSender.send(message);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
