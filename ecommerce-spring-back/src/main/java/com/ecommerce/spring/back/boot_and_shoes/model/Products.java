package com.ecommerce.spring.back.boot_and_shoes.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Products {

    private UUID id;

    private String name;

    private String description;

    private String gender;

    private BigDecimal price;

    private String imageUrl;

    private Brands brands;



}
