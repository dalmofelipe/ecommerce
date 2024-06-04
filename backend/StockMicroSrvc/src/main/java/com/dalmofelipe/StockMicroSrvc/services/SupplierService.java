package com.dalmofelipe.StockMicroSrvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmofelipe.StockMicroSrvc.exceptions.AlreadyExistsException;
import com.dalmofelipe.StockMicroSrvc.exceptions.NotFoundException;
import com.dalmofelipe.StockMicroSrvc.models.Supplier;
import com.dalmofelipe.StockMicroSrvc.records.SupplierInput;
import com.dalmofelipe.StockMicroSrvc.repositories.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier getById(Integer supplierId) {
        return supplierRepository.findById(supplierId)
            .orElseThrow(() -> new NotFoundException("supplier not found"));
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier create(SupplierInput supplierInput) {
        Optional<Supplier> supplierOpt = supplierRepository.findByName(supplierInput.name());
        if (supplierOpt.isPresent()) throw new AlreadyExistsException("supplier already exist");

        Supplier supplier = new Supplier();
        supplier.setName(supplierInput.name());

        return supplierRepository.save(supplier);
    }
}
