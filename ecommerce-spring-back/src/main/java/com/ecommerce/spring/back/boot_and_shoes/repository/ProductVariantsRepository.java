package com.ecommerce.spring.back.boot_and_shoes.repository;

import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsVariantsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface ProductVariantsRepository  extends JpaRepository<ProductsVariantsEntity, UUID>, JpaSpecificationExecutor<ProductsVariantsEntity> {
    @Query("SELECT pv FROM ProductsVariantsEntity pv WHERE pv.productsEntity.id = :productId")
    List<ProductsVariantsEntity> findVariantsByProductId(@Param("productId") UUID productId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductsVariantsEntity p WHERE p.productsEntity.id = :productId")
    void deleteByProductId(@Param("productId") UUID productId);
}
