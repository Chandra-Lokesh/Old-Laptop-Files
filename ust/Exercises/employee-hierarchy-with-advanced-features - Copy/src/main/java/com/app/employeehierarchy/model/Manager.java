package com.app.employeehierarchy.model;

import java.util.Random;

public non-sealed class Manager extends Employee{

    public Manager(Employee e) {
        super(e.getUid(), e.getName(), e.getJobRole(), e.getSalary());
    }
}
