package com.app.employeehierarchy.model;


public non-sealed class Regular extends Employee {

    public Regular(Employee e) {
        super(e.getUid(), e.getName(), e.getJobRole(), e.getSalary());
    }

}
