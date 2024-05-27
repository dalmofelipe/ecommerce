package com.dalmofelipe.StockMicroSrvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmofelipe.StockMicroSrvc.models.Category;
import com.dalmofelipe.StockMicroSrvc.records.CategoryInput;
import com.dalmofelipe.StockMicroSrvc.services.CategoryService;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/categories")
    public ResponseEntity<Category> create(@Validated @RequestBody CategoryInput categoryInput) {
        return ResponseEntity.ok(categoryService.create(categoryInput));
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getById(@PathVariable(name = "id") Integer categoryId) {
        return ResponseEntity.ok(categoryService.getById(categoryId));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listAll() {
        return ResponseEntity.ok(categoryService.listAll());
    }
    
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer categoryId) {
        categoryService.deleteById(categoryId);
        return ResponseEntity.noContent().build();
    }

}
