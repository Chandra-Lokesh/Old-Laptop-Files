package com.app.employeehierarchy.model;


public sealed class Employee permits Regular, Manager, Executive {

    private int uid;
    private String name;
    private String jobRole;
    private double salary;

    public Employee(int uid, String name, String jobRole, double salary) {
        this.uid = uid;
        this.name = name;
        this.jobRole = jobRole;
        this.salary = salary;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", salary=" + salary +
                '}';
    }
}
