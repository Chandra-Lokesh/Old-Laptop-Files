package org.example;

import org.example.beans.Phone;
import org.example.beans.Sim;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Phone phone = new Phone();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Phone phone = context.getBean("pixel", Phone.class);
//        Phone phone = context.getBean(Phone.class);
//        phone.call("2389743829");
//        phone.sendText("32974823324", "Hello Bro");
//        System.out.println(phone.toString());
    }
}