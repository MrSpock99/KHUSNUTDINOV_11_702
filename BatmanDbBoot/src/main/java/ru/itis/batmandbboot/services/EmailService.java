package ru.itis.batmandbboot.services;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}
