package com.ust.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
//@Document
public class Project {
//    @Id
//    @Field(name = "_id")
//    private int id;
    private String title;
    private Status status;
}
