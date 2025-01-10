package streamapi.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> list = List.of("Harsh", "Karan", "Lokesh", "Mohit");

        // Sort in reverse order
        var reverseList = list.stream()
                        .sorted(Comparator.reverseOrder())
                                        .collect(Collectors.toList());
        System.out.println(reverseList);


        // Find names starts with H or M
        var nameList = list.stream()
                        .filter(i -> i.charAt(0)=='H' || i.charAt(0)=='M')
                                .collect(Collectors.toList());
        System.out.println(nameList);

//        var namesWithHAndM= list.stream()
//                .filter(i-> i.startsWith("H") || i.startsWith("M"))
//                .collect(Collectors.toList());
//        System.out.println(namesWithHAndM);


        // Return a single comma separated string containing all the names
//        var str = list.stream()
//                        .collect(Collectors.joining(", "));

        var str = list.stream()
                .reduce((name, s)-> name+", "+s);
        System.out.println(str);

    }
}
