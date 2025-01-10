package com.myportfolio.mutualfundsms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MutualFund {
    @Id
    private int id;
    private String fundName;
    private double amountInvested;
    private double growthRate;
}
