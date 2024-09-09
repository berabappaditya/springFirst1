package com.example.springFirst1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springFirst1.extensions.ProductNotFoundException;
import com.example.springFirst1.models.Product;
import com.example.springFirst1.repositories.ProductRepository;

@Service("OwnProductService")
//instead if using @Primary we can use @Qualifier at parent constructor 
//@Primary
public class OwnProductService implements ProductService {
    ProductRepository productRepository;
    public OwnProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product putProduct(long id, Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
