package com.myportfolio.stocksms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stock {

    @Id
    private int id;
    private String name;
    private double price;

}
