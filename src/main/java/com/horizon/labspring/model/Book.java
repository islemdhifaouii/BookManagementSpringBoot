package com.horizon.labspring.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Book {
    private int id;
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @NotBlank(message = "ISBN cannot be blank")
    @Pattern(regexp = "^\\d{2}-\\d{3}-\\d{3}$", message = "Invalid ISBN format")
    private String ISBN;
    @Min(value = 0, message = "Price cannot be negative")
    private double price;
    @Min(value = 0, message = "quantity cannot be negative")
    private double quantity;
    private String category;
}