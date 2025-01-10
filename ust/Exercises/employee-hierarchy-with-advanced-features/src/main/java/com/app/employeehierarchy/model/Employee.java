package com.app.employeehierarchy.model;


public record Employee(int id, String name, String jobRole, Double salary) implements EmployeeInterface{



}
