package com.ust.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Data
@Document
public class UserModel {

    @Id
    @Field(name = "_id")
    private BigInteger id;

    private String userName;
    private String password;
    private String role;

}
