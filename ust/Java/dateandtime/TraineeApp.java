package dateandtime;

import streamapi.Trainee;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TraineeApp {
    public static void main(String[] args) {

        Traineee t1 = new Traineee(1, "name1", LocalDate.parse("2010-08-18"));
        Traineee t2 = new Traineee(2, "name2", LocalDate.parse("2002-08-10"));
        Traineee t3 = new Traineee(3, "name3", LocalDate.parse("2023-02-12"));
        Traineee t4 = new Traineee(4, "name4", LocalDate.parse("2013-08-11"));
        Traineee t5 = new Traineee(5, "name5", LocalDate.parse("2012-01-07"));

        var trainees = List.of(t1, t2, t3, t4, t5);

        var senior = trainees.stream()
                .min((tr1, tr2)->tr1.getDatejoined().compareTo(tr2.getDatejoined()));

        System.out.println(senior);

    }
}
