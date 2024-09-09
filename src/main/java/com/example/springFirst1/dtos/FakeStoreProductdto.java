package com.example.springFirst1.dtos;

// import com.example.springFirst1.models.Category;

// import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductdto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    
}
