package com.app.employeehierarchy;

import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.service.EmployeeHierarchyService;

import java.util.Random;
import java.util.Scanner;

public class EmployeeHierarchyMain {

    public static void main(String[] args) {

        EmployeeHierarchyService service = new EmployeeHierarchyService();
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // Todo: Add employees to the system.
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 1", "Manager", 60000.0));
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 2", "Regular", 40000.0));
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 3", "Regular", 15000.0));
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 4", "Executive", 20000.0));
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 5", "Manager", 89000.0));
        service.addEmployee(new Employee(100000 + rand.nextInt(900000), "Name 6", "Regular", 32000.0));


        // Todo: Retrieve and display employee information.
        Employee retrievedEmployee = service.getEmployeeById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee);

        while(true){
            System.out.println("\n1. Display all employees \n2. Retrieve Employee\n3. Get Job Role\n4. Increments Salary\n5. Exit");
            System.out.println("Select a Choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    service.displayAllEmployees();
                    break;
                case 2:
                    System.out.println("Enter uid:");
                    int uid = sc.nextInt();
                    Employee e = service.getEmployeeById(uid);
                    System.out.println(e);
                    break;
                case 3:
                    System.out.println("Enter uid:");
                    uid = sc.nextInt();
                    e = service.getEmployeeById(uid);
                    System.out.println(e.getClass());
                case 4:
                    service.incrementSalary();
                case 5:
                    return;
                default:
                    System.out.println("Enter valid choice");

            }
        }

        // Todo: Calculate and display total salary expenditure.
//        double totalSalaryExpenditure = service.calculateTotalSalaryExpenditure();
//        System.out.println("Total Salary Expenditure: $" + totalSalaryExpenditure);

        // Todo: Perform additional operations as needed.
    }
}
