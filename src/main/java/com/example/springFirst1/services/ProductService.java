package com.example.springFirst1.services;
import java.util.List;

import com.example.springFirst1.extensions.ProductNotFoundException;
import com.example.springFirst1.models.Product;


public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(long id) throws ProductNotFoundException;
    public Product putProduct(long  id,Product product);
}
