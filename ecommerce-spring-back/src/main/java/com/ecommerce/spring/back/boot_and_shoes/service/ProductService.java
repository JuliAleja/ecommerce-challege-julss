package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.model.Products;

import java.util.List;

public interface ProductService {

    Products create (Products products);

    List<Products> all();

}
