package com.workshop.ecommerce.service;

import java.util.List;

import com.workshop.ecommerce.dto.CategoryDTO;
import com.workshop.ecommerce.model.Category;

import jakarta.validation.Valid;

public interface CategoryService {

     CategoryDTO createCategory(CategoryDTO categoryDTO) ;

     List<Category> getAllCategories();

     CategoryDTO getCategoryById(Long id);

     CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

     void deleteCategory(Long id);
    
}