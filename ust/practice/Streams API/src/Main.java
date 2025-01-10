import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = List.of(4, 1, 3, 2, 5);
//        list.forEach(i -> System.out.print((i * i) + " "));
//        Stream<Integer> stream = list.stream();
//        stream.forEach(i -> System.out.print(i * i + " "));
//        System.out.println(stream.count());
//        Stream<Integer> sortedList = list.stream().sorted();
//        sortedList.forEach(i -> System.out.print(i * i + " "));
//        int result = list.stream()
//                        .filter(i -> i % 2 != 0)
//                        .sorted()
//                        .map(n -> n*n)
//                        .forEach(System.out::println);
//                        .reduce(0,(c, e) -> c + e);
//        System.out.println(result);

        // average
        List<Integer> list = List.of(4, 1, 3, 2, 5);
        double average = list.stream().mapToInt(i -> i.intValue()).average().orElse(0);
        System.out.println(average);

        // to uppercase / to lowercase
        List<String> l1 = List.of("apple", "banana", "mango", "orange");
//        List<String> ul1 = l1.stream().map(i -> i.toUpperCase()).toList();
        List<String> ul1 = l1.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
        System.out.println(ul1);

        // sum of all even/ odd numbers
        List<Integer> l2 = List.of(4, 1, 3, 2, 5);
//        System.out.println(l2.stream().filter(i -> i % 2 == 0).reduce(0, (a,b) -> a + b));
        System.out.println(l2.stream().filter(i -> i%2==0).mapToInt(i->i.intValue()).sum());

        // remove duplicates
        List<Integer> l3 = List.of(4, 1, 3, 2, 5, 1, 4, 2);
        l3.stream().distinct().forEach(i -> System.out.print(i + " "));

        // count string starting with specific letter
        List<String> l4 = List.of("apple", "banana", "mango", "orange", "oreo", "omelette");
        int r1 = (int)l4.stream().filter(i -> i.charAt(0) == 'o').count();
        System.out.println("\n" + r1);

        // sort strings
        l4.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // max min in list
        System.out.println("max: " + l2.stream().mapToInt(i -> i.intValue()).max().orElse(0));
        System.out.println("min: " + l2.stream().mapToInt(i -> i.intValue()).min().orElse(0));

        // second largest / smallest
        int secondLargest = l2.stream().sorted(Comparator.reverseOrder()).skip(1).mapToInt(i -> i.intValue()).max().orElse(0);
        System.out.println(secondLargest);
        int secondSmallest = l2.stream()
                .sorted()
                .skip(1)
                .findFirst().orElse(0);
//                .min(Comparator.comparing(i -> i)).orElse(0);
        System.out.println(secondSmallest);
    }
}