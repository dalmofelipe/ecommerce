package com.dalmofelipe.StockMicroSrvc.records;

import jakarta.validation.constraints.NotNull;

public record SupplierInput(
    @NotNull String name
) {}
