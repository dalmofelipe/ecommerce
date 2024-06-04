package com.dalmofelipe.StockMicroSrvc.mappers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalmofelipe.StockMicroSrvc.exceptions.BadRequestException;
import com.dalmofelipe.StockMicroSrvc.models.Product;
import com.dalmofelipe.StockMicroSrvc.models.Stock;
import com.dalmofelipe.StockMicroSrvc.models.Supplier;
import com.dalmofelipe.StockMicroSrvc.records.StockControl;
import com.dalmofelipe.StockMicroSrvc.repositories.ProductRepository;
import com.dalmofelipe.StockMicroSrvc.repositories.SupplierRepository;

@Component
public class StockMapperDecorator implements StockMapper {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Stock toModel(StockControl stockControl) {
        if (stockControl == null) {
            return null;
        }

        Stock stock = new Stock();
        
        stock.setAmount(stockControl.amount() != 0 ? stockControl.amount() : null);
        stock.setLotPrice(stockControl.lotPrice() != BigDecimal.valueOf(0) ? stockControl.lotPrice() : null);
        stock.setType(stockControl.type());
        stock.setRegistredAt(stockControl.registredAt());
        stock.setValidUntil(stockControl.validUntil());

        Product product = productRepository.findById(stockControl.productId())
            .orElseThrow(() -> new BadRequestException("product not found in mapper decorator"));
        
        Supplier supplier = supplierRepository.findById(stockControl.supplierId())
            .orElseThrow(() -> new BadRequestException("supplier not found in mapper decorator"));

        stock.setProduct(product);
        stock.setSupplier(supplier);

        return stock;
    }
}