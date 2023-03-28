package com.mlm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerCustomRepository {
	
}