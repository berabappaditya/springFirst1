package com.example.springFirst1.demoDBInheritence.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joinedtb_instructor")
public class Instructor extends User {
    private String specialization;
}
