package com.example.springFirst1.demoDBInheritence.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "joinetb_user")
public class User {
    @Id
    @PrimaryKeyJoinColumn(name = "user_id")
    private long id;
    private String name;
    private String email;
    private String password;

}
