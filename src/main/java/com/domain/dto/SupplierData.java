package com.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SupplierData {
    
    @NotEmpty(message = "name is required")
    private String name;
    
    @NotEmpty(message = "address is required")
    private String address;
    
    @NotEmpty(message = "email is required")
    @Email(message = "email is not valid")
    private String email;
}
