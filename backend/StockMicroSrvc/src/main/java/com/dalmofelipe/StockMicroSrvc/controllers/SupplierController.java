package com.dalmofelipe.StockMicroSrvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmofelipe.StockMicroSrvc.models.Supplier;
import com.dalmofelipe.StockMicroSrvc.records.SupplierInput;
import com.dalmofelipe.StockMicroSrvc.services.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers/{id}")
    private ResponseEntity<Supplier> getById(@PathVariable(name = "id") Integer supplierId) {
        return ResponseEntity.ok(supplierService.getById(supplierId));
    }

    @GetMapping("/suppliers")
    private ResponseEntity<List<Supplier>> getAll() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @PostMapping("/suppliers")
    private ResponseEntity<Supplier> create(@Validated @RequestBody SupplierInput supplierInput) {
        return ResponseEntity.ok(supplierService.create(supplierInput));
    }

}
