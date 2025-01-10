package com.myportfolio.portfolioms.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Stock {

    private int id;
    private String name;
    private double price;

}
