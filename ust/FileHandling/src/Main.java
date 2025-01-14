import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("/src/Data.txt");
        try {
            Stream<String> list = Files.lines(path);
            Stream<String> processedList = list.map(item -> item.toUpperCase()).map(item -> item.trim());
            processedList.forEach(item-> System.out.print(item + " "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}