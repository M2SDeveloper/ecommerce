package com.workshop.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.workshop.ecommerce.dto.ProductDTO;
import com.workshop.ecommerce.model.Category;
import com.workshop.ecommerce.model.Product;
import com.workshop.ecommerce.repository.ProductRepository;
import com.workshop.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

     private final ProductRepository productRepository;  
     public ProductDTO createProduct(ProductDTO product){

        try {
        Product productEntity= mapToEntity(product);

        Category category= new Category();
        category.setId(1l);

        productEntity.setCategory(category);

        Product productDB= productRepository.save(productEntity);

        return mapToDTO(productDB);
            
        } catch (Exception e) {
            System.out.println(e);
        }
         return null;
        
     }

     private ProductDTO mapToDTO(Product productDB) {
        ProductDTO product = new ProductDTO();
        product.setName(productDB.getName());
        product.setDescription(productDB.getDescription());
        product.setPrice(productDB.getPrice());
        product.setStockQuantity(productDB.getStockQuantity());
        product.setImageUrl(productDB.getImageUrl());
        
        return product;
    }

     private Product mapToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setImageUrl(productDTO.getImageUrl());
        
        return product;
    }

    
}
