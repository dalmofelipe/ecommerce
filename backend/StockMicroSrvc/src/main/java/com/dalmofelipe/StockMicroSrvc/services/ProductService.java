package com.dalmofelipe.StockMicroSrvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmofelipe.StockMicroSrvc.exceptions.AlreadyExistsException;
import com.dalmofelipe.StockMicroSrvc.exceptions.NotFoundException;
import com.dalmofelipe.StockMicroSrvc.mappers.ProductMapper;
import com.dalmofelipe.StockMicroSrvc.models.Category;
import com.dalmofelipe.StockMicroSrvc.models.Product;
import com.dalmofelipe.StockMicroSrvc.records.ProductInput;
import com.dalmofelipe.StockMicroSrvc.repositories.CategoryRepository;
import com.dalmofelipe.StockMicroSrvc.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;    


    public Product create(ProductInput productInput) {
        Optional<Product> productOpt = productRepository
            .findByNameAndBrandAndDetails(productInput.name(), productInput.brand(), 
                productInput.details());

        if(productOpt.isPresent())
            throw new AlreadyExistsException("product already exist");

        Category categoryFind = categoryRepository
            .findById(productInput.categoryId())
            .orElseThrow(() -> new NotFoundException(
                String.format("category id '%d' not found", productInput.categoryId())));

        Product productDb = productInput.toModel();
        productDb.setCategory(categoryFind);
        
        return productRepository.save(productDb);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product getOne(Integer productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new NotFoundException("product not found"));
    }

    public Product update(ProductInput productInput, Integer productId) {
        Product productDb = productRepository.findById(productId)
            .orElseThrow(() -> new NotFoundException(
                String.format("product id '%d' not found", productId)));

        Optional<Product> productOpt = productRepository
            .findByNameAndBrandAndDetails(productInput.name(), productInput.brand(), 
                productInput.details());

        if(productOpt.isPresent())
            throw new AlreadyExistsException("product already exist");

        productMapper.toUpdate(productDb, productInput);
        
        return productRepository.save(productDb);
    }

    public void delete(Integer productId) {
        productRepository.deleteById(productId);
    }

}
