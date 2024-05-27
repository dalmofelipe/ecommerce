package com.dalmofelipe.StockMicroSrvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmofelipe.StockMicroSrvc.exceptions.AlreadyExistsException;
import com.dalmofelipe.StockMicroSrvc.exceptions.NotFoundException;
import com.dalmofelipe.StockMicroSrvc.models.Category;
import com.dalmofelipe.StockMicroSrvc.records.CategoryInput;
import com.dalmofelipe.StockMicroSrvc.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(CategoryInput categoryInput) {
        Optional<Category> categoryExistOpt = categoryRepository.findByName(categoryInput.name());
        if (categoryExistOpt.isPresent()) throw new AlreadyExistsException("category already exist");

        Optional<Category> categoryRootOpt = categoryRepository.findById(categoryInput.categoryRootId());
        if (categoryRootOpt.isEmpty()) throw new AlreadyExistsException("category not found");

        var category = categoryInput.toModel();
        var categoryRoot = categoryRootOpt.get();

        category.setCategoryRoot(categoryRoot);

        return categoryRepository.save(category);
    }

    public Category getById(Integer categoryId) {
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);

        if(categoryOpt.isEmpty()) throw new NotFoundException("category not found");

        return categoryOpt.get();
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
