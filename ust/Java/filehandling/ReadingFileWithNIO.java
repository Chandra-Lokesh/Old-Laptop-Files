package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileWithNIO {
    public static void main(String[] args) {
        /*try {
            Files.lines(Paths.get("filehandling/data.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Path dir = Paths.get("filehanding/data.txt");
    }
}
