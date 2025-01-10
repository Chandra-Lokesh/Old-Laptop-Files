package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sim {

    @Autowired
//    @Qualifier("NetworkNotAvailable")
    Network network;
    @Value("${sim.provider}")
    String provider;

    pubilc Sim(){
        System.out.println("Sim Bean Created");
    }

    public void call(String phNo){
        if(network.isAvailable())
            System.out.println("Calling " + phNo + " using " + provider + " sim.");
        else
            System.out.println("Couldn't make a call due to network issues");
    }

    public void sendText(String phNo, String message){
        if(network.isAvailable())
            System.out.println("""
                Sent
                %s
                to
                %s
                """.formatted(phNo, message));
        else
            System.out.println("Couldn't make a call due to network issues");
    }
}
