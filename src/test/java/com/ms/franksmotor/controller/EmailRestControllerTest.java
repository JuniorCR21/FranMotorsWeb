package com.ms.franksmotor.controller;

import com.ms.franksmotor.model.request.MailRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "20000")
class EmailRestControllerTest {

    @Autowired
    private WebTestClient webClient;
    
    @Test
    void sendMailTest() {
        MailRequest request = new MailRequest();
        request.setSubject("Vehiculo Listo!");
        request.setText("Su vehiculo ya se encuentra listo para el recojo");
        request.setToUser("juniorcr2198@gmail.com");
        request.setName("Junior Carrión");
        this.webClient.post()
            .uri("/franksmotor/v1/email/send")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(String.class);
    }
}
