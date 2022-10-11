package com.example.demo.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Product {
    @Id
    @Column
    private int productId;
    @Column
    private String productName;
    @Column
    private String productDescription;
}
