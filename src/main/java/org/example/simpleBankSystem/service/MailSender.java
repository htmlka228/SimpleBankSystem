package org.example.simpleBankSystem.service;

public interface MailSender {
    void send(String emailTo, String subject, String message);
}
