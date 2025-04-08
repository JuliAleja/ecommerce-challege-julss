package com.ecommerce.spring.back.boot_and_shoes.model.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductsVariantsCreateResponse {
    private UUID id;

    private String size;

    private String color;

    private Integer stock;
}
