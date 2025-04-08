package com.ecommerce.spring.back.boot_and_shoes.controller;

import com.ecommerce.spring.back.boot_and_shoes.entities.ProductsEntity;
import com.ecommerce.spring.back.boot_and_shoes.model.*;
import com.ecommerce.spring.back.boot_and_shoes.model.Request.ProductsCreateRQ;
import com.ecommerce.spring.back.boot_and_shoes.model.Request.ProductsVariantsCreateRQ;
import com.ecommerce.spring.back.boot_and_shoes.model.Response.ProductsCreateResponse;
import com.ecommerce.spring.back.boot_and_shoes.model.Response.ProductsVariantsCreateResponse;
import com.ecommerce.spring.back.boot_and_shoes.service.BrandService;
import com.ecommerce.spring.back.boot_and_shoes.service.ProductService;
import com.ecommerce.spring.back.boot_and_shoes.service.ProductVariantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${request-mapping.controller.managament-product}")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductVariantsService productVariantsService;
    private final BrandService brandService;

    @PostMapping("save-product")
    public ResponseEntity<ProductsCreateResponse> createProduct(@RequestBody ProductsCreateRQ productsCreateRQ) {
        Brands brands=brandService.finById(productsCreateRQ.getBrandId());
        Products product= new Products();
        product.setBrands(brands);
        product.setName(productsCreateRQ.getName());
        product.setDescription(productsCreateRQ.getDescription());
        product.setGender(productsCreateRQ.getGender());
        product.setPrice(productsCreateRQ.getPrice());
        product.setImageUrl(productsCreateRQ.getImageUrl());
        Products productSaved=productService.create(product);
        List<ProductsVariants> productsVariants = new ArrayList<>();
        for (ProductsVariantsCreateRQ productsVariantsCreateRQList :productsCreateRQ.getVariantsList()){
            ProductsVariants productsVariantsAdd= new ProductsVariants();
            productsVariantsAdd.setProduct(productSaved);
            productsVariantsAdd.setSize(productsVariantsCreateRQList.getSize());
            productsVariantsAdd.setStock(productsVariantsCreateRQList.getStock());
            productsVariantsAdd.setColor(productsVariantsCreateRQList.getColor());
            productsVariants.add(productsVariantsAdd);
        }
        List<ProductsVariants> productsVariantsListSaved= productVariantsService.creates(productsVariants);
        List<ProductsVariantsCreateResponse> productsVariantsSaved = new ArrayList<>();
        for (ProductsVariants productsVariantsResponseList :productsVariantsListSaved){
            ProductsVariantsCreateResponse productsVariantsAdd= new ProductsVariantsCreateResponse();
            productsVariantsAdd.setId(productsVariantsResponseList.getId());
            productsVariantsAdd.setSize(productsVariantsResponseList.getSize());
            productsVariantsAdd.setStock(productsVariantsResponseList.getStock());
            productsVariantsAdd.setColor(productsVariantsResponseList.getColor());
            productsVariantsSaved.add(productsVariantsAdd);
        }
        ProductsCreateResponse productResponse= new ProductsCreateResponse();
        productResponse.setId(productSaved.getId());
        productResponse.setName(productSaved.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setBrands(productSaved.getBrands());
        productResponse.setPrice(productSaved.getPrice());
        productResponse.setImageUrl(product.getImageUrl());
        productResponse.setVariantsList(productsVariantsSaved);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("all-products")
    public ResponseEntity<List<ProductsCreateResponse>> allProducts() {
        List<Products> products= productService.all();
        List<ProductsCreateResponse> productResponses = new ArrayList<>();

        for (Products product :products){
        ProductsCreateResponse productResponse= new ProductsCreateResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setDescription(product.getDescription());
            productResponse.setBrands(product.getBrands());
            productResponse.setGender(product.getGender());
            productResponse.setPrice(product.getPrice());
            productResponse.setImageUrl(product.getImageUrl());
            List<ProductsVariants> productsVariantsFinds= productVariantsService.findAllById(product.getId());
            List<ProductsVariantsCreateResponse> productsVariantsSaved = new ArrayList<>();
            for (ProductsVariants productsVariantsResponseList :productsVariantsFinds){
                ProductsVariantsCreateResponse productsVariantsAdd= new ProductsVariantsCreateResponse();
                productsVariantsAdd.setId(productsVariantsResponseList.getId());
                productsVariantsAdd.setSize(productsVariantsResponseList.getSize());
                productsVariantsAdd.setStock(productsVariantsResponseList.getStock());
                productsVariantsAdd.setColor(productsVariantsResponseList.getColor());
                productsVariantsSaved.add(productsVariantsAdd);
            }
            productResponse.setVariantsList(productsVariantsSaved);
            productResponses.add(productResponse);

        }
        return ResponseEntity.ok(productResponses);
    }
}
