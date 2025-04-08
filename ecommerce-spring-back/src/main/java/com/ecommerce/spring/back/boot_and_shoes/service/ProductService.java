package com.ecommerce.spring.back.boot_and_shoes.service;

import com.ecommerce.spring.back.boot_and_shoes.model.Products;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Products create (Products products);

    List<Products> all();

    Products findById (UUID uuid);

    void delete (UUID id);

}
