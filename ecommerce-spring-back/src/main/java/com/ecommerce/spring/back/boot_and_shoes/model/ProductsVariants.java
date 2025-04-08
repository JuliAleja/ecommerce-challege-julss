package com.ecommerce.spring.back.boot_and_shoes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
public class ProductsVariants {

    private UUID id;

    private Products product;

    private String size;

    private String color;

    private Integer stock;
}
