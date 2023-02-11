package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_categories")

public class Category extends BaseEntity<String> implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;
}
