package exception_handling;

import java.util.Scanner;

public class ThrowingAnException {
    public static void getAge() throws InvalidAgeException{
        int age;
        System.out.println("Age: ");
        age = new Scanner(System.in).nextInt();

        if(age <= 0 || age > 100){
            throw new InvalidAgeException("Sorry! Invalid Age");
        }
        System.out.println("Age: " + age);
    }
    public static void main(String[] args){
        try {
            getAge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
