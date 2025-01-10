package streamapi;

import java.util.Set;
import java.util.stream.Collectors;

public class SetExample {
    public static void main(String[] args) {
        Trainee t1 = new Trainee(1, "lokesh1", "Hyderabad");
        Trainee t2 = new Trainee(2, "lokesh2", "Kerala");
        Trainee t3 = new Trainee(3, "lokesh3", "Tamil Nadu");
        Trainee t4 = new Trainee(4, "lokesh4", "Kerala");
        Set<Trainee> trainees = Set.of(t1, t2, t3, t4);
//        var mallus = trainees.stream()
//                .filter(t -> t.getLocation().equalsIgnoreCase("Kerala"))
//                .collect(Collectors.toSet());

        var mallus = trainees.stream()
                .filter(t -> t.getLocation().equalsIgnoreCase("Kerala"))
                .collect(Collectors.toSet());
        mallus.forEach(System.out::println);
    }
}
