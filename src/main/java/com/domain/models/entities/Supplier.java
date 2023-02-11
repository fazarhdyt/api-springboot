package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_suppliers")
// @JsonIdentityInfo(
//     generator = ObjectIdGenerators.PropertyGenerator.class,
//     property = "id"
// )
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String address;

    @Column(length = 25, nullable = false, unique = true)
    private String email;

    @ManyToMany(mappedBy = "suppliers")
    @JsonBackReference
    private Set<Product> products;
}
