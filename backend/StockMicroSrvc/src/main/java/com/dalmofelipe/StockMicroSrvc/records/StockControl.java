package com.dalmofelipe.StockMicroSrvc.records;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import com.dalmofelipe.StockMicroSrvc.models.enums.StockType;

public record StockControl(
    @NotNull @Min(1) Integer productId,
    @NotNull @Min(1) Integer amount, 
    @NotNull StockType type, 
    LocalDate validUntil
) {}
