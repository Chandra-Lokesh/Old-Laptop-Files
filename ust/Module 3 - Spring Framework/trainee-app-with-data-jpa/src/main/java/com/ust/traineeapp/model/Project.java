package com.ust.traineeapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    @Enumerated(EnumType.STRING)
    private Status status;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Trainee trainee;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "project_trainees",
//            joinColumns = @JoinColumn(name = "project_id"),
//
//    )
    @JsonIgnore
    private List<Trainee> trainees = new ArrayList<>();
}