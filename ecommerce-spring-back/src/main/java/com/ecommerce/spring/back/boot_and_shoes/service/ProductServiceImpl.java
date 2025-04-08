package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsEntity;
import com.ecommerce.spring.back.boot_and_shoes.mapper.ProductMapper;
import com.ecommerce.spring.back.boot_and_shoes.model.Products;
import com.ecommerce.spring.back.boot_and_shoes.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    @Override
    public Products create(Products products) {
        ProductsEntity productsEntity= productMapper.toEntity(products);
        ProductsEntity productsEntitySaved= productRepository.save(productsEntity);

        return productMapper.toDomain(productsEntitySaved);
    }

    @Override
    public List<Products> all() {
        List<ProductsEntity> productsEntity= productRepository.findAll();

        return productMapper.toDomains(productsEntity);    }
}
