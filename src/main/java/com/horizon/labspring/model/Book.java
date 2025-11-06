package com.horizon.labspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Table(name="boks")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private String title;

    @Column
    @NotBlank(message = "Author cannot be blank")
    private String author;

    //@NotBlank(message = "ISBN cannot be blank")
    @Pattern(regexp = "^\\d{2}-\\d{3}-\\d{3}$", message = "Invalid ISBN format")
    @Column(unique = true)
    private String Isbn;

    @Min(value = 0, message = "Price cannot be negative")
    @Column
    private double price;

    @Column(nullable = false)
    @Min(value = 0, message = "quantity cannot be negative")
    private double quantity;
    @Column(nullable = false)
    private String category;
}