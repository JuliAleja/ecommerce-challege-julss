package com.ecommerce.spring.back.boot_and_shoes.mapper;

import com.ecommerce.spring.back.boot_and_shoes.entities.BrandsEntity;
import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsEntity;
import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsVariantsEntity;
import com.ecommerce.spring.back.boot_and_shoes.model.Brands;
import com.ecommerce.spring.back.boot_and_shoes.model.Products;
import com.ecommerce.spring.back.boot_and_shoes.model.ProductsVariants;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductVariantsMapper {
    default List<ProductsVariantsEntity> toEntities (List<ProductsVariants> domains){
        {
            if ( domains == null ) {
                return null;
            }

            List<ProductsVariantsEntity> list = new ArrayList<ProductsVariantsEntity>( domains.size() );
            for ( ProductsVariants productsVariants : domains ) {
                list.add( toEntity( productsVariants ) );
            }

            return list;
        }
    }
    default List<ProductsVariants> toDomains (List<ProductsVariantsEntity> entities){
        if ( entities == null ) {
            return null;
        }

        List<ProductsVariants> list = new ArrayList<ProductsVariants>( entities.size() );
        for ( ProductsVariantsEntity productsVariantsEntity : entities ) {
            list.add( toDomain( productsVariantsEntity ) );
        }

        return list;
    }
    default ProductsVariantsEntity toEntity(ProductsVariants domain) {
        if ( domain == null ) {
            return null;
        }
        BrandsEntity brandsEntity= new BrandsEntity();
        brandsEntity.setId(domain.getProduct().getBrands().getId());
        brandsEntity.setName(domain.getProduct().getBrands().getName());
        brandsEntity.setDescription(domain.getProduct().getBrands().getDescription());

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setId( domain.getProduct().getId() );
        productsEntity.setName( domain.getProduct().getName() );
        productsEntity.setDescription( domain.getProduct().getDescription() );
        productsEntity.setGender( domain.getProduct().getGender() );
        productsEntity.setPrice( domain.getProduct().getPrice() );
        productsEntity.setImageUrl( domain.getProduct().getImageUrl() );
        productsEntity.setBrandsEntity(brandsEntity);

        ProductsVariantsEntity productsVariantsEntity = new ProductsVariantsEntity();
        productsVariantsEntity.setId( domain.getId() );
        productsVariantsEntity.setSize( domain.getSize() );
        productsVariantsEntity.setColor( domain.getColor() );
        productsVariantsEntity.setStock( domain.getStock() );
        productsVariantsEntity.setProductsEntity(productsEntity);

        return productsVariantsEntity;
    }

    default ProductsVariants toDomain(ProductsVariantsEntity entity) {
        if ( entity == null ) {
            return null;
        }
        Brands brands= new Brands();

        brands.setId(entity.getProductsEntity().getBrandsEntity().getId());
        brands.setName(entity.getProductsEntity().getBrandsEntity().getName());
        brands.setDescription(entity.getProductsEntity().getBrandsEntity().getDescription());

        Products products = new Products();

        products.setId( entity.getProductsEntity().getId() );
        products.setName( entity.getProductsEntity().getName() );
        products.setDescription( entity.getProductsEntity().getDescription() );
        products.setGender( entity.getProductsEntity().getGender() );
        products.setPrice( entity.getProductsEntity().getPrice() );
        products.setImageUrl( entity.getProductsEntity().getImageUrl() );
        products.setBrands(brands);

        ProductsVariants productsVariants = new ProductsVariants();

        productsVariants.setId( entity.getId() );
        productsVariants.setSize( entity.getSize() );
        productsVariants.setColor( entity.getColor() );
        productsVariants.setStock( entity.getStock() );

        return productsVariants;
    }

}
