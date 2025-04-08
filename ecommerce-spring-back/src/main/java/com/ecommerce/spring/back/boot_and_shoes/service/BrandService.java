package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.model.Brands;

import java.util.UUID;

public interface BrandService {
    Brands create (Brands brands);

    Brands finById (UUID uuid);

}
