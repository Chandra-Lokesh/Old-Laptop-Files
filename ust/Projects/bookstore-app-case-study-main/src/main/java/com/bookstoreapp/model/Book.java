package com.bookstoreapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Generated;
//import lombok.NoArgsConstructor;

//import javax.persistence.*;
//import javax.validation.Valid;
//import javax.validation.constraints.*;



@Data
@AllArgsConstructor
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @Column(length = 100)
    @NotEmpty
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @Column(length = 200)
    @NotEmpty
    private String author;

    // The publication year should be a valid year
    @Min(value = 1800)
    @Max(value = 2024)
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    @Digits(integer = 13, fraction = 0)
    private long isbn;

    // The price should be a positive decimal value.
    @DecimalMin(value = "0", inclusive = false)
    private double price;

}
