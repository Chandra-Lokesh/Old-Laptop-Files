package org.example.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class EmailNotificationImpl implements EmailNotification{
    @Override
    public void sendEmail(String subject, String body) {
        System.out.println("""
                Sub: %s
                Dear Sir/Madam,
                %s
                Best Regards,
                John Doe
                %s
                
                Email Sent Successfully!
                ------------------------
                """.formatted(subject, body, LocalDate.now() + " " + LocalTime.now()));
    }
}
