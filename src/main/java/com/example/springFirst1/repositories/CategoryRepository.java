package com.example.springFirst1.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springFirst1.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    <S extends Category> S save(S entity);

    @Override
    Optional<Category> findById(Long id);


}
