package com.dalmofelipe.StockMicroSrvc.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalmofelipe.StockMicroSrvc.exceptions.BadRequestException;
import com.dalmofelipe.StockMicroSrvc.models.Product;
import com.dalmofelipe.StockMicroSrvc.models.Stock;
import com.dalmofelipe.StockMicroSrvc.records.StockControl;
import com.dalmofelipe.StockMicroSrvc.repositories.ProductRepository;

@Component
public class StockMapperDecorator implements StockMapper {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Stock toModel(StockControl stockControl) {
        if (stockControl == null) {
            return null;
        }

        Stock stock = new Stock();
        
        stock.setAmount(stockControl.amount() != 0 ? stockControl.amount() : null);
        stock.setType(stockControl.type());
        stock.setValidUntil(stockControl.validUntil());

        Product product = productRepository.findById(stockControl.productId())
            .orElseThrow(() -> new BadRequestException("product not found in mapper decorator"));
        
        stock.setProduct(product);

        return stock;
    }
}