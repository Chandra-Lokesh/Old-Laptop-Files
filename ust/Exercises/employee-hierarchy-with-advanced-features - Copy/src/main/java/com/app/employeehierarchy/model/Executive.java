package com.app.employeehierarchy.model;

import java.util.Random;

public non-sealed class Executive extends Employee{

    public Executive(Employee e) {
        super(e.getUid(), e.getName(), e.getJobRole(), e.getSalary());
    }
}
