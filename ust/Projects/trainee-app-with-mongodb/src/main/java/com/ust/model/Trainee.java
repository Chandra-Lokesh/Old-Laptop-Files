package com.ust.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document
public class Trainee {

    @Id
    @JsonProperty("id")
    @Field(name = "_id")
    private int id;

    private String name;
    private String location;

    @Field(name = "joinDate")
    private LocalDate joinedDate;

    private String uuid = UUID.randomUUID().toString();

    private Project project;

}
