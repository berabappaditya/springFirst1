package com.example.springFirst1.demoDBInheritence.singletable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
}
