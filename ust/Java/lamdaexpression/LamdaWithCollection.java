package lamdaexpression;

import java.util.List;

public class LamdaWithCollection {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,20,30,40,50,60);
        list.forEach(value -> System.out.println(value));
    }
}
