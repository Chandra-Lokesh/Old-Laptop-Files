package com.bookstoreapp.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Id
    @Field(name = "_id")
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @Size()
    @NotBlank
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @NotBlank
    @Size()
    private String author;

    // The publication year should be a valid year
    @PastOrPresent
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    @Digits(integer = 13, fraction = 0)
    private long isbn;

    // The price should be a positive decimal value.
    @Positive
    private double price;

}
