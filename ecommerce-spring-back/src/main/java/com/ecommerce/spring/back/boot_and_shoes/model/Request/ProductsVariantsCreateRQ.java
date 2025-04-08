package com.ecommerce.spring.back.boot_and_shoes.model.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductsVariantsCreateRQ {

    private String size;

    private String color;

    private Integer stock;
}
