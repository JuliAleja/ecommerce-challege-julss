package com.ecommerce.spring.back.boot_and_shoes.controller;

import com.ecommerce.spring.back.boot_and_shoes.model.Brands;
import com.ecommerce.spring.back.boot_and_shoes.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${request-mapping.controller.managament-brand}")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping("save-brand")
    public ResponseEntity<Brands> createBrand(@RequestBody Brands brand) {
        Brands response=brandService.create(brand);
        return ResponseEntity.ok(response);
    }

}
