package com.workshop.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

    
} 
