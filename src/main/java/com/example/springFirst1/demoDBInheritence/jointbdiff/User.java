package com.example.springFirst1.demoDBInheritence.jointbdiff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "diffjoinetb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // It will automatically generate the primary key
    private long id;

    private String name;
    private String email;
    private String password;
}
