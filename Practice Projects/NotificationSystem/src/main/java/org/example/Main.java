package org.example;

import org.example.config.AppConfig;
import org.example.model.Phone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Phone phone = context.getBean(Phone.class);

        phone.sendMessageViaMail();
        phone.sendMessageViaSMS();
    }
}