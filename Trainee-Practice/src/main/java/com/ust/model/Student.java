package com.ust.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    int id;
    String name;

    @ManyToOne
    College college;
}
