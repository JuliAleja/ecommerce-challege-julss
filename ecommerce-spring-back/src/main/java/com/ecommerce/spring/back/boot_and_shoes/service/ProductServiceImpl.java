package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsEntity;
import com.ecommerce.spring.back.boot_and_shoes.mapper.ProductMapper;
import com.ecommerce.spring.back.boot_and_shoes.model.Products;
import com.ecommerce.spring.back.boot_and_shoes.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        return productMapper.toDomains(productsEntity);
    }

    @Override
    public Products findById(UUID uuid) {
        ProductsEntity productsEntitySaved= productRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + uuid));;
        return productMapper.toDomain(productsEntitySaved);
    }

    @Override
    public void delete(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
