package com.ecommerce.spring.back.boot_and_shoes.mapper;

import com.ecommerce.spring.back.boot_and_shoes.entities.BrandsEntity;
import com.ecommerce.spring.back.boot_and_shoes.model.Brands;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandsEntity toEntity(Brands domain);

    Brands toDomain(BrandsEntity entity);
}
