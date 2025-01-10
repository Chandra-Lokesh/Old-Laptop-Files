package com.app.employeehierarchy.service;

import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.model.Executive;
import com.app.employeehierarchy.model.Manager;
import com.app.employeehierarchy.model.Regular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeHierarchyService {

    private List<Employee> employees = new ArrayList<>();

    // Todo: Implement a method to add an employee to the system.
    public void addEmployee(Employee employee) {
        // Todo: Add logic to add an employee to the system.
        if(employee.getJobRole().equals("Regular")){
            Employee regEmployee = new Regular(employee);
            employees.add(regEmployee);
        }
        else if(employee.getJobRole().equals("Manager")){
            Employee manEmployee = new Manager(employee);
            employees.add(manEmployee);
        }
        else if(employee.getJobRole().equals("Executive")){
            Employee exeEmployee = new Executive(employee);
            employees.add(exeEmployee);
        }
    }

    // Todo: Implement a method to get an employee by ID.
    public Employee getEmployeeById(int employeeId) {
        // Todo: Add logic to retrieve an employee by ID.
        return employees.stream().filter(e -> e.getUid() == employeeId).findFirst().orElse(null);
        // Placeholder, replace with actual implementation.
    }

    public void displayDetails(Employee e){
        System.out.println(e.toString());
    }

    public void displayAllEmployees(){
        employees.stream().forEach(e-> System.out.println(e.toString()));
    }

    public void incrementSalary(){
        employees.forEach(e-> {
            double newSalary = 0;
            if(e instanceof Regular){
                newSalary = e.getSalary();
                newSalary += newSalary * 0.05;
            }
            else if(e instanceof Manager){
                newSalary = e.getSalary();
                newSalary += newSalary * 0.1;
            }
            else if(e instanceof Executive){
                newSalary = e.getSalary();
                newSalary += newSalary * 0.15;
            }
            e.setSalary(newSalary);
        });
        this.displayAllEmployees();
    }

    // Todo: Implement a method to calculate total salary expenditure.
    public double calculateTotalSalaryExpenditure() {
        // Todo: Add logic to calculate the total salary expenditure.
        return employees.stream().mapToDouble(e -> e.getSalary()).sum();
        // Placeholder, replace with actual implementation.
    }

    // Todo: Implement additional methods for employee management.

}
