package com.example.springFirst1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springFirst1.models.Product;

//JpaRepository<ModelName, dataType>
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
