package com.ecommerce.spring.back.boot_and_shoes.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Brands {

    private UUID id;

    private String name;

    private String description;

    private List<Products> productsList;
}
