package com.dalmofelipe.StockMicroSrvc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalmofelipe.StockMicroSrvc.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
    Optional<Supplier> findByName(String name);

}
