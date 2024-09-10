package com.example.springFirst1.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springFirst1.extensions.ProductNotFoundException;
import com.example.springFirst1.models.Category;
import com.example.springFirst1.models.Product;
import com.example.springFirst1.repositories.CategoryRepository;
import com.example.springFirst1.repositories.ProductRepository;

@Service("OwnProductService")
//instead if using @Primary we can use @Qualifier at parent constructor 
//@Primary
public class OwnProductService implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public OwnProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        Category category = product.getCategory();
        if(category.getId() == null) {
            category = categoryRepository.save(category);
            product.setCategory(category);
            product.setUpdatedAt(LocalDate.now());
        }
        Product savedProduct = productRepository.save(product);
        // Optional<Category> categoryOptional = categoryRepository.findById(savedProduct.getCategory().getId());
        // savedProduct.setCategory(categoryOptional.get());
        return savedProduct;

    }
    @Override
    public List<Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            return productOptional.get();
        }
        throw new UnsupportedOperationException("Product not found with id: " + id);
    }

    @Override
    public Product putProduct(long id, Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
