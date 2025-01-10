package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Phone {
    @Autowired
    EmailNotificationImpl email;
    @Autowired
    SMSNotificationImpl sms;

    @Value("${message.subject}")
    String subject;
    @Value("${message.body}")
    String body;

    public void sendMessageViaMail(){
        email.sendEmail(subject, body);
    }

    public void sendMessageViaSMS(){
        sms.sendSMS(body);
    }
}
