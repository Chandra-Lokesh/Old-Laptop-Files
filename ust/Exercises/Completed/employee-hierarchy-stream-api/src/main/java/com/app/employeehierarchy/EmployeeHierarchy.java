package com.app.employeehierarchy;


import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeHierarchy {

    // DONE: Use Stream API to find the employee with the highest salary
    public static Employee findHighestPaidEmployee(List<Employee> employees) {
        return employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .get();
    }


    // DONE: Use Stream API to count the number of developers in the collection
    public static long countDevelopers(List<Employee> employees) {
        return employees.stream().filter(item -> item instanceof Developer).count();
    }

    // DONE: Use Stream API to calculate the average salary of all employees
    public static double calculateAverageSalary(List<Employee> employees) {
        int sum = 0;
        return employees.stream().mapToDouble(item -> item.getSalary()).average().getAsDouble();
    }


    public static void main(String[] args) {
        // Create a collection to store employees
        List<Employee> employeeList = new ArrayList<>();

        // DONE: Add sample Manager and Developer instances to the collection
        Employee d1 = new Developer(1, "name1", 20000.0, "java");
        Employee d2 = new Developer(2, "name2", 40000.0, "python");
        Employee d3 = new Developer(3, "name3", 80000.0, "cpp");

        Employee m1 = new Manager(4, "name4", 30000.0, 10);
        Employee m2 = new Manager(5, "name5", 50000.0, 11);
        Employee m3 = new Manager(6, "name6", 70000.0, 12);

        employeeList = List.of(d1, d2, d3, m1, m2, m3);

        // DONE: Print the initial list of employees
        System.out.println(employeeList);

        // DONE: Use Stream API to filter employees based on salary range and display the results
        List<Employee> list = employeeList.stream().filter(item-> item.getSalary() <= 30000)
                        .collect(Collectors.toList());
        System.out.println(list);

        // DONE: Use Stream API to calculate the total salary of all employees
        double totalSalary = employeeList.stream().mapToDouble(item-> item.getSalary()).sum();
        System.out.println("Total Salary: " + totalSalary);

        // TODO: Allow user input to add new employees to the collection
        // TODO: Implement a user interface to interact with the program

    }
}
