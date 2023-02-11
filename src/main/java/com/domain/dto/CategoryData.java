package com.domain.dto;


import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CategoryData {

    private Long id;
    
    @NotEmpty(message = "category name is required")
    private String name;
}
