package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_product")
// @JsonIdentityInfo(
//     generator = ObjectIdGenerators.PropertyGenerator.class,
//     property = "id"
// )
public class Product implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name is required")
    @Column(name = "product_name", length = 45)
    private String name;

    @Column(name = "product_description", length = 500)
    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
        name = "tbl_product_supplier",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    @JsonManagedReference
    private Set<Supplier> suppliers;
}
