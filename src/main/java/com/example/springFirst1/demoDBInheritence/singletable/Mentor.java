package com.example.springFirst1.demoDBInheritence.singletable;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User{
    private String company;
    private String avg_rating;

}
