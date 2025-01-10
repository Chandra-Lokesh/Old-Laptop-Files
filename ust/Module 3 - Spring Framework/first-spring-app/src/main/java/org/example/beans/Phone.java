package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Phone {

    @Autowired
    private Sim sim;

    @Value("${phone.brand}")
    private String brand;
    @Value("${phone.model}")
    private String model;
    @Value("${phone.price}")
    private double price;

    public Phone() {
        System.out.println("Phone Bean Created");
    }

    public Phone(Sim sim){
        this.sim = sim;
    }

    public Sim getSim() {
        return sim;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSim(Sim sim) {
        this.sim = sim;
    }

    public void call(String phNo){
        sim.call(phNo);
    }
    public void sendText(String phNo, String message){
        sim.sendText(message, phNo);
    }

    @Override
    public String toString() {
        return "Phone{"+
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
