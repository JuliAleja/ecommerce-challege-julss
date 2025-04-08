package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.entities.BrandsEntity;
import com.ecommerce.spring.back.boot_and_shoes.mapper.BrandMapper;
import com.ecommerce.spring.back.boot_and_shoes.model.Brands;
import com.ecommerce.spring.back.boot_and_shoes.repository.BrandRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    @Override
    public Brands create(Brands brands) {
        BrandsEntity brandsEntity=brandMapper.toEntity(brands);
        BrandsEntity brandsEntitySave=brandRepository.save(brandsEntity);
        return brandMapper.toDomain(brandsEntitySave);
    }

    @Override
    public Brands finById(UUID uuid) {
        BrandsEntity brandsEntity = brandRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + uuid));
        return brandMapper.toDomain(brandsEntity);
    }
}
