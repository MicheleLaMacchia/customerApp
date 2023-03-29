package com.mlm.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerCustomRepository {
	
	@Query("SELECT c FROM Customer c WHERE c.age >= :minAge AND c.age <= :maxAge")
	List<Customer> findCustomersByAgeAndLastName(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

	
}