package com.mlm.customer.repository.custom;

import java.util.List;

import com.mlm.customer.repository.model.Customer;

public interface CustomerCustomRepository {

	public List<Customer> customFindAll();
	
}
