package com.example.springFirst1.demoDBInheritence.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joinedtb_ta")
public class Ta extends User {
    private int no_of_sessions;
    private String avg_rating;

    
}
