package filehandling;

import java.io.*;
import java.util.Scanner;

public class ReadingFile {
    public static void main(String[] args) {
        try{
//            InputStream input = new FileInputStream("filehandling/data.txt");
//            Scanner scanner = new Scanner(input);
//
//            while (scanner.hasNextLine()){
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//            int ch;
//            while((ch = input.read()) != -1){
//                System.out.print((char)ch);
//            }

            String line = """
                    Hello all,
                    We are fucking soldiers
                    """;
//            OutputStream outputStream = new FileOutputStream("filehandling/data.txt");
//            outputStream.write(line);
            FileWriter fw = new FileWriter("filehandling/data.txt");
            fw.write(line);
            fw.close();
//            FileReader fr = new FileReader("filehandling/data.txt");
//            int ch;
//            while((ch = fr.read()) != -1){
//                System.out.print((char)ch);
//            }

        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
