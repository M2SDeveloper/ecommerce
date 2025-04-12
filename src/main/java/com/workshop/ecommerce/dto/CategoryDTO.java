package com.workshop.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "category name is required")
    private String name;

    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<ProductDTO> products= new ArrayList<>();

    private String discription;

    private LocalDateTime createdAt;

    private LocalDateTime updateddAt;
    
}
