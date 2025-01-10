package com.ust.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    int id;
    String name;
    int age;
    String email;
}
