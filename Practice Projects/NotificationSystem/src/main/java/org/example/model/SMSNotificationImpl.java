package org.example.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class SMSNotificationImpl implements SMSNotification{
    @Override
    public void sendSMS(String message) {
        System.out.println("""
                Dear Sir/Madam,
                %s
                %s
                
                SMS Sent Successfully!
                ----------------------
                """.formatted(message, LocalDate.now() + " " + LocalTime.now()));
    }
}
