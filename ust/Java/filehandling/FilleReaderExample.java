package filehandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilleReaderExample {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        try {

            while(true){
                System.out.println("\n1. Enter text to be Written\n2. Read Contents of File\n3. Exit\nSelect a choice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        FileWriter fw = new FileWriter("filehandling/Info.txt", true);
                        sc.nextLine();
                        System.out.println("Enter text:");
                        String input = sc.nextLine();
                        fw.append(input).append("\n");
                        fw.close();
                        break;
                    case 2:
                        FileReader fr = new FileReader("filehandling/Info.txt");
                        int ch;
                        boolean isEmpty = true;
                        System.out.println("-----------------");
                        while ((ch = fr.read()) != -1) {
                            isEmpty = false;
                            System.out.print((char) ch);
                        }
                        if(isEmpty)
                            System.out.print("File is Empty!");
                        System.out.println("\n-----------------");
                        fr.close();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
