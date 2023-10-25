package com.cupcakestore.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cupcakestore.store.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Long>{

    void deleteProductById(Long id);
    Optional<Product> findProductById(Long id);
}
