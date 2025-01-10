package com.myportfolio.portfolioms.dto;


import lombok.Data;

@Data
public class MutualFund {
    private int id;
    private String fundName;
    private double amountInvested;
    private double growthRate;
}