public abstract class Employee {
    String name;
    int employeeID;
    double salary;

    public Employee(String name, int employeeID, double salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("\n" + this.getClass().getName() + " Details:\nName: " + name +
                "\nEmployee ID: " + employeeID +
                "\nSalary: " + salary);
    }
}
