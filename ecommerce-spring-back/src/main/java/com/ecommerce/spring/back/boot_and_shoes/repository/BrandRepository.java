package com.ecommerce.spring.back.boot_and_shoes.repository;

import com.ecommerce.spring.back.boot_and_shoes.entities.BrandsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BrandRepository  extends JpaRepository<BrandsEntity, UUID>, JpaSpecificationExecutor<BrandsEntity> {
}
