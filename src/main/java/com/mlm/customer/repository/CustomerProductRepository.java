package com.mlm.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mlm.customer.repository.model.CustomerProduct;
import com.mlm.customer.repository.model.Product;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {
	
	@Query("SELECT p FROM Product p JOIN CustomerProduct cp ON cp.product.id = p.id WHERE cp.customer.id = :customerId")
    List<Product> findProductsByCustomerId(@Param("customerId") Long customerId);
	
}