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
public interface ProductMapper {
    default ProductsEntity toEntity(Products domain){
        if ( domain == null ) {
            return null;
        }
        BrandsEntity brandsEntity= new BrandsEntity();
        brandsEntity.setId(domain.getBrands().getId());
        brandsEntity.setName(domain.getBrands().getName());
        brandsEntity.setDescription(domain.getBrands().getDescription());

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setId( domain.getId() );
        productsEntity.setName( domain.getName() );
        productsEntity.setDescription( domain.getDescription() );
        productsEntity.setGender( domain.getGender() );
        productsEntity.setPrice( domain.getPrice() );
        productsEntity.setImageUrl( domain.getImageUrl() );
        productsEntity.setBrandsEntity(brandsEntity);
        return productsEntity;
    };

    default Products toDomain(ProductsEntity entity){
        {
            if ( entity == null ) {
                return null;
            }
            Brands brands= new Brands();
            brands.setId(entity.getBrandsEntity().getId());
            brands.setName(entity.getBrandsEntity().getName());
            brands.setDescription(entity.getBrandsEntity().getDescription());

            Products products = new Products();

            products.setId( entity.getId() );
            products.setName( entity.getName() );
            products.setDescription( entity.getDescription() );
            products.setGender( entity.getGender() );
            products.setPrice( entity.getPrice() );
            products.setImageUrl( entity.getImageUrl() );
            products.setBrands(brands);

            return products;
        }
    };
    default List<ProductsEntity> toEntities (List<Products> domains){
        {
            if ( domains == null ) {
                return null;
            }

            List<ProductsEntity> list = new ArrayList<ProductsEntity>( domains.size() );
            for ( Products products : domains ) {
                list.add( toEntity( products ) );
            }

            return list;
        }
    }
    default List<Products> toDomains (List<ProductsEntity> entities){
        if ( entities == null ) {
            return null;
        }

        List<Products> list = new ArrayList<Products>( entities.size() );
        for ( ProductsEntity productsEntity : entities ) {
            list.add( toDomain( productsEntity ) );
        }

        return list;
    }
}
