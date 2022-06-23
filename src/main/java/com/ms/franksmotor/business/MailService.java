package com.ms.franksmotor.business;

public interface MailService {

    public void sendEmail(String subject, String text, String toUser);
}
