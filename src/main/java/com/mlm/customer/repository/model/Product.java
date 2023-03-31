package com.mlm.customer.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    private String barcode;
    
    private String productName;
    
    private String productCategory;
    
    private Double cost;

}
