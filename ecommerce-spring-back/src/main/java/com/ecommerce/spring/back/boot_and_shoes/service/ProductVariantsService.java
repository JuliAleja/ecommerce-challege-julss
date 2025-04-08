package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.model.ProductsVariants;

import java.util.List;
import java.util.UUID;

public interface ProductVariantsService {
    List<ProductsVariants> creates (List<ProductsVariants> productsVariants);
    List<ProductsVariants> findAllById(UUID productId);
}
