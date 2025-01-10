package dateandtime;

import java.time.LocalDate;

public class Traineee {
    private int id;
    private String name;
    private LocalDate datejoined;

    public Traineee(int id, String name, LocalDate datejoined) {
        this.id = id;
        this.name = name;
        this.datejoined = datejoined;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDatejoined() {
        return datejoined;
    }

    @Override
    public String toString() {
        return "Traineee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", datejoined=" + datejoined +
                '}';
    }
}
