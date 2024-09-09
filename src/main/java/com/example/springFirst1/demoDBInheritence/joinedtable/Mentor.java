package com.example.springFirst1.demoDBInheritence.joinedtable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joinedtb_mentor")
public class Mentor extends User{
    private String company;
    private String avg_rating;

}
