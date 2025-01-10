package records;

import java.time.LocalDate;

public record Trainee(int id, String name, LocalDate dateJoined) {
    public Trainee(int id){
        this(id, null, null);
    }
    public Trainee(int id, String name){
        this(id, name, null);
    }
}
