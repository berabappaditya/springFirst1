package com.example.springFirst1.extensions;

import lombok.Getter;
import lombok.Setter;

//IF WE want unchecked exception we will extend RuntimeException
@Getter
@Setter
public class ProductNotFoundException  extends Exception {
    private long id;
    public ProductNotFoundException(long id,String message) {
        super(message);
        this.id = id;
    }
    
}
