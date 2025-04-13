package com.workshop.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByName(String name);
    
}
