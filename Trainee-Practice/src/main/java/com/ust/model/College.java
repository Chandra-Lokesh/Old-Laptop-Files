package com.ust.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class College {
    @Id
    int id;
    String name;

//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "college")
    @JsonIgnore
    List<Student> studentList = new ArrayList<>();
}
