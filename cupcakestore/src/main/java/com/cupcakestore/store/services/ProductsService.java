package com.cupcakestore.store.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cupcakestore.store.exceptions.ProductNotFoundException;
import com.cupcakestore.store.models.Product;
import com.cupcakestore.store.repository.ProductsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductsService {
    // Attributes
    private final ProductsRepository productsRepo;

    // Constructor
    @Autowired
    public ProductsService(ProductsRepository productsRepo) {
        this.productsRepo = productsRepo;
    }

    // Functions
    public Product addProduct(Product product) {
        return productsRepo.save(product);
    }

    public List<Product> listAllProducts() {
        return productsRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productsRepo.save(product);
    }

    public Product findProduct(Long id) {
        return productsRepo.findProductById(id).orElseThrow(() -> new ProductNotFoundException ("Product not found"));
    }

    public void deleteProduct(Long id) {
        productsRepo.deleteProductById(id);
    }
}
