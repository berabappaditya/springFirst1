package com.example.springFirst1.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String image;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;
}
