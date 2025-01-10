package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Network {
    @Value("${network.available}")
    private boolean available;

    public Network(){
        System.out.println("Network Bean Created");
    }

    public Network(boolean available){
        this.available = available;
    }

    public boolean isAvailable(){
        return available;
    }
}
