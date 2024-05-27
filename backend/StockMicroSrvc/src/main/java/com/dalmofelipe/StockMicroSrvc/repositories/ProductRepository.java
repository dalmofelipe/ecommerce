package com.dalmofelipe.StockMicroSrvc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalmofelipe.StockMicroSrvc.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    Optional<Product> findByNameAndBrandAndDetails(String name, String brand, String details);

}
