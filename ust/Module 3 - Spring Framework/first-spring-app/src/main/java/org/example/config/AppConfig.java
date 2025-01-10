package org.example.config;

import org.example.beans.Network;
import org.example.beans.Phone;
import org.example.beans.Sim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.beans")
@PropertySource("app.properties")
public class AppConfig {

//    @Bean
//    public Sim getSimObject(){
//        return new Sim();
//    }
//
//    @Bean("iphone")
//    public Phone getIPhoneBean(){
//        Phone phone = new Phone();
//        phone.setBrand("Apple");
//        phone.setModel("iPhone 16 Pro");
//        phone.setPrice(119999.0);
//
//        return phone;
//    }
//
//    @Bean("pixel")
//    public Phone getPixelBean(){
//        Phone phone = new Phone();
//        phone.setBrand("Google");
//        phone.setModel("Pixel 8");
//        phone.setPrice(37000.0);
//
//        return phone;
//    }
//
//    @Bean("networkAvailable")
//    public Network getNetworkBean(){
//        return new Network(true);
//    }
//
//    @Bean("NetworkNotAvailable")
//    public Network getNoNetworkBean(){
//        return new Network(false);
//    }

}
