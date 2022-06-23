package com.ms.franksmotor.controllers;

import com.ms.franksmotor.business.MailService;
import com.ms.franksmotor.model.request.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franksmotor/v1/email")
public class EmailRestController {

    @Autowired
    private MailService mailService;
    
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody MailRequest mail) {
        mailService.sendEmail("Servicio de Atencion: " + mail.getSubject(), 
                mail.getText(), mail.getToUser());
        return ResponseEntity.ok("Enviado");
    }
}
