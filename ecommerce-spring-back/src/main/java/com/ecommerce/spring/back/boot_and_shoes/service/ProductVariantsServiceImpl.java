package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.entities.BrandsEntity;
import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsEntity;
import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsVariantsEntity;
import com.ecommerce.spring.back.boot_and_shoes.mapper.ProductVariantsMapper;
import com.ecommerce.spring.back.boot_and_shoes.model.ProductsVariants;
import com.ecommerce.spring.back.boot_and_shoes.repository.ProductVariantsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductVariantsServiceImpl implements  ProductVariantsService{

    private final ProductVariantsMapper productVariantsMapper;
    private final ProductVariantsRepository productVariantsRepository;
    @Override
    public List<ProductsVariants> creates(List<ProductsVariants> productsVariants) {
        List<ProductsVariantsEntity> productsVariantsEntities= productVariantsMapper.toEntities(productsVariants);
        List<ProductsVariantsEntity> productsVariantsEntitiesSaved= productVariantsRepository.saveAll(productsVariantsEntities);
        return productVariantsMapper.toDomains(productsVariantsEntitiesSaved);
    }

    @Override
    public List<ProductsVariants> findAllById(UUID productId) {
        List<ProductsVariantsEntity> entities = productVariantsRepository.findVariantsByProductId(productId);
        return productVariantsMapper.toDomains(entities);
    }
}

