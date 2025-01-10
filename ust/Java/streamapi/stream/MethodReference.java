package streamapi.stream;

import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
//        var list = List.of(10, 20, 30, 40, 50);
//        list.forEach(i-> System.out.print(i+", "));
//        list.forEach(System.out::print);

        List<String> list = List.of("Harsh", "Karan", "Lokesh", "Mohit");

        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
