package com.example.springFirst1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


//this controller will be containing http  request and response
@RestController
// this is the url which will be used to access the method
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/")
    public String getMethodName() {
        return "Main route mapping";
    }

    
    @GetMapping("/printArr")
    public int[] printArr() {
        int[] arr ={1,3,4,5};
         return arr;
    }

    //how to get a path varioble
    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    

    @GetMapping("/getparams")
    public String getParams(@RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "age", required = false) Integer age) {
        return "hi"+name+"your age is"+age;
    }
    
    

    @GetMapping("/world")
    public String sample2() {
        return "Hello World";
    }
    
}
