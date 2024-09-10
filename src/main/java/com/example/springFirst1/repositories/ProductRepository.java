package com.example.springFirst1.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springFirst1.models.Product;
import com.example.springFirst1.projections.ProductTItleDescProjection;

//JpaRepository<ModelName, dataType>
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    <S extends Product> S save(S entity);

    @Override
    Optional<Product> findById(Long id);

    @Query("SELECT p.title as title ,p.description as description FROM Product p WHERE p.id = :id")
    ProductTItleDescProjection customQuery(@Param("id") Long id);

    @Override
    <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);




    @Override
    public default Product getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public default Product getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public default <S extends Product> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public default <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
