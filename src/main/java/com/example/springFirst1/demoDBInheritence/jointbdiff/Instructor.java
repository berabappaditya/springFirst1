package com.example.springFirst1.demoDBInheritence.jointbdiff ;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "diffjoinedtb_instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // It will automatically generate the primary key
    private long id;  // Instructor's own primary key

    private String specialization;

    @ManyToOne
    @JoinColumn(name = "user_id")  // This will create a foreign key column referencing User's id
    private User user;
}
