package com.mlm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.CustomerProduct;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long>, CustomerCustomRepository {
	
}