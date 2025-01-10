package exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

    public class Checked {
        public static void main(String[] args) {
            try{
                FileReader fd = new FileReader("hello.txt");
                Scanner sc = new Scanner(fd);
                System.out.println(sc.nextLine());
            } catch (FileNotFoundException fne){
                fne.printStackTrace();
            }
        }
    }
