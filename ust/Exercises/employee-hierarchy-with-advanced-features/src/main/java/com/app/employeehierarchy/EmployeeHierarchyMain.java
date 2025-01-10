package com.app.employeehierarchy;

import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.service.EmployeeHierarchyService;

import java.util.Random;

public class EmployeeHierarchyMain {

    public static void main(String[] args) {

        Random random = new Random();
        EmployeeHierarchyService service = new EmployeeHierarchyService();

        // Todo: Add employees to the system.
        service.addEmployee(new Employee(100000+random.nextInt(), "John Doe", "Manager", 60000.0));
        service.addEmployee(new Employee(2, "Jane Smith", "Developer", 50000.0));

        // Todo: Retrieve and display employee information.
        Employee retrievedEmployee = service.getEmployeeById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee);

        // Todo: Calculate and display total salary expenditure.
        double totalSalaryExpenditure = service.calculateTotalSalaryExpenditure();
        System.out.println("Total Salary Expenditure: $" + totalSalaryExpenditure);

        // Todo: Perform additional operations as needed.
    }
}
