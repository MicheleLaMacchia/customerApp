package com.mlm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}