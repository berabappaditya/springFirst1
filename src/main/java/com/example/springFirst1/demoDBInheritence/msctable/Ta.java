package com.example.springFirst1.demoDBInheritence.msctable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ta extends User {
    private int no_of_sessions;
    private String avg_rating;

    
}
