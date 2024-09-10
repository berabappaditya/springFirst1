package com.example.springFirst1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//we can we use lombok to generate getters and setters
//we can also use @Data annotation to generate getters and setters

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private String image;
    @ManyToOne
    private Category category;
}
