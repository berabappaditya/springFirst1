package com.example.springFirst1.demoDBInheritence.msctable;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;

}
