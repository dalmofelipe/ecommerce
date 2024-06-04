package com.dalmofelipe.StockMicroSrvc.records;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.dalmofelipe.StockMicroSrvc.models.enums.StockType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record StockControl(
    @NotNull @Min(1) Integer productId,
    @NotNull @Min(1) Integer supplierId,
    @NotNull @Min(1) Integer amount,
    @NotNull @Min(1) BigDecimal lotPrice,
    @NotNull StockType type, 
    LocalDate registredAt,
    LocalDate validUntil
) {}
