package com.app.employeehierarchy.service;

import com.app.employeehierarchy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHierarchyService {

    private List<Employee> employees = new ArrayList<>();

    // Todo: Implement a method to add an employee to the system.
    public void addEmployee(Employee employee) {
        // Todo: Add logic to add an employee to the system.
        employees.add(employee);
    }

    // Todo: Implement a method to get an employee by ID.
    public Employee getEmployeeById(int employeeId) {
        // Todo: Add logic to retrieve an employee by ID.
        return employees.stream().filter(e -> e.id() == employeeId).findFirst().orElse(null);
        // Placeholder, replace with actual implementation.
    }

    // Todo: Implement a method to calculate total salary expenditure.
    public double calculateTotalSalaryExpenditure() {
        // Todo: Add logic to calculate the total salary expenditure.
        return employees.stream().mapToDouble(e -> e.salary()).sum();
        // Placeholder, replace with actual implementation.
    }

    // Todo: Implement additional methods for employee management.

}
