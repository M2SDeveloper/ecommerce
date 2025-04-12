package com.workshop.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.ecommerce.dto.ProductDTO;
import com.workshop.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/heartbeat")
    public String getApiStatus() {
        return new String("Hi, This is my first spring boot API.. I am running on 8080 port ");
    }
    
    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
       
        return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED) ;
    }
    
    
    
}
