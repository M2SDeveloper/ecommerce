package com.workshop.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workshop.ecommerce.dto.CategoryDTO;
import com.workshop.ecommerce.exception.ResourceAlreadyExistsException;
import com.workshop.ecommerce.exception.ResourceNotFoundException;
import com.workshop.ecommerce.model.Category;
import com.workshop.ecommerce.repository.CategoryRepository;

import com.workshop.ecommerce.service.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

     private final CategoryRepository categoryRepository;  

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryDTO responseCategoryDTO= new CategoryDTO();
        try {
            Category category= new Category();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            Category categoryDB= categoryRepository.save(category);
            responseCategoryDTO=mapToDTO(categoryDB);
        } catch (Exception e) {
           
        }
       return  responseCategoryDTO;
    }

    private CategoryDTO mapToDTO(Category categoryDB) {
        CategoryDTO cDto=new CategoryDTO();
        cDto.setId(categoryDB.getId());
        cDto.setDescription(categoryDB.getDescription());
        cDto.setName(categoryDB.getName());
        cDto.setCreatedAt(categoryDB.getCreatedAt());
        cDto.setUpdateddAt(categoryDB.getUpdatedAt());
        return cDto;
    }

    @Override
    public List<Category> getAllCategories() {
         return categoryRepository.findAll();
    }

      @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id not found"));
        
        return mapToDTO(category);
    }


    @Override
    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        
        // Check if category with the new name already exists (if name is being changed)
        if (!category.getName().equals(categoryDTO.getName()) && 
                categoryRepository.existsByName(categoryDTO.getName())) {
            throw new ResourceAlreadyExistsException("Category with name '" + categoryDTO.getName() + "' already exists");
        }
        
        // Update fields
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        
        // Save updated category
        Category updatedCategory = categoryRepository.save(category);
        
        return mapToDTO(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        // Check if category exists
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
        
        categoryRepository.deleteById(id);
    }


}
