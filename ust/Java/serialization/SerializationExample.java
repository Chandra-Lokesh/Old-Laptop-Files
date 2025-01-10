package serialization;

import java.io.*;

public class SerializationExample{
    public static void main(String[] args) {
        Trainee trainee = new Trainee(1, "john", "john@gmial.com");
        System.out.println("Before Serialization: " + trainee);

        try(
                OutputStream output = new FileOutputStream("trainee.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);



                ){

        } catch(FileNotFoundException fe){
            throw new RuntimeException(fe);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
