package com.dalmofelipe.StockMicroSrvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dalmofelipe.StockMicroSrvc.exceptions.BadRequestException;
import com.dalmofelipe.StockMicroSrvc.exceptions.BusinessException;
import com.dalmofelipe.StockMicroSrvc.mappers.StockMapper;
import com.dalmofelipe.StockMicroSrvc.models.Stock;
import com.dalmofelipe.StockMicroSrvc.models.enums.StockType;
import com.dalmofelipe.StockMicroSrvc.records.StockControl;
import com.dalmofelipe.StockMicroSrvc.repositories.ProductRepository;
import com.dalmofelipe.StockMicroSrvc.repositories.StockRepository;

@Service
public class StockService {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    protected final StockMapper stockMapper;

    public StockService(StockMapper stockMapper, StockRepository stockRepository, 
            ProductRepository productRepository) {
        this.stockMapper = stockMapper;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    public Stock registerControl(StockControl control) {
        var stockControlModel =  stockMapper.toModel(control);

        productRepository.findById(control.productId())
            .orElseThrow(() -> new BadRequestException(
                String.format("product id '%d' unregistred", control.productId())));
        
        if(control.type().equals(StockType.ENTRY))
            return stockRepository.save(stockControlModel);

        var totalProductInStock = stockRepository.getTotalAmounts(control.productId());

        if(totalProductInStock == null) 
            throw new BusinessException(
                String.format("no records of product id '%d' in stock", control.productId()));

        if(totalProductInStock >= stockControlModel.getAmount())               
            return stockRepository.save(stockControlModel);

        throw new BusinessException("product insufficient amount in stock");
    }

    public List<Stock> listAll() {
        return stockRepository.findAll();
    }

}
