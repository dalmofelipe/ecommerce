package com.dalmofelipe.StockMicroSrvc.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.dalmofelipe.StockMicroSrvc.models.Stock;
import com.dalmofelipe.StockMicroSrvc.records.StockControl;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(StockMapperDecorator.class)
public interface StockMapper {

    public Stock toModel(StockControl mapper);

}
