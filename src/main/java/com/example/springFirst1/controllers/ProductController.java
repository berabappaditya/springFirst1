package com.example.springFirst1.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springFirst1.extensions.ProductNotFoundException;
import com.example.springFirst1.models.Product;
import com.example.springFirst1.services.ProductService;




@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    ProductController(@Qualifier("OwnProductService") ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product) { // can use dto also
        //TODO: process POST request
        
        return productService.createProduct(product);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {

        //Use of exception handling
        // if(id >200) {
        //     throw new RuntimeException(":::::::::____ Product not found ____________::::::::::");
        // }

        ResponseEntity<Product> responseEntity = null;
        // try {
            Product product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        // } catch (Exception  e) {

        //     responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //     System.out.println(e);
        // }
        // new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // Product product = productService.getProductById(id);

        //VVI : defferent ways to return a response Entity
       // return new ResponseEntity<>(product, null, 404);
       // return ResponseEntity.ok(product);
      // return ResponseEntity.ok().body(product);
      // return new ResponseEntity<>(product, HttpStatus.OK );

      return responseEntity;

    }
    
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable long id, @RequestBody Product entity) {
        //TODO: process PUT request
        
        return productService.putProduct(id, entity);
    }

    //create product
    //update product - patch
    //replace product - put
    //delete product
    
    // Controller specific exception handling
    // it will handle all the exceptions thrown by the controller global eception handler will work for this controller
    //  @ExceptionHandler(Exception.class)
    //  public ResponseEntity<String> handleException(Exception e) {
    //     return null;
    // }

 
}
