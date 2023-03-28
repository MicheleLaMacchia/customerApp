package com.mlm.customer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.Customer;

public class CustomerRepositoryImpl implements CustomerCustomRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> customFindAll() {
		
		Query query = entityManager.createNativeQuery("select * from Customers", Customer.class);

		return query.getResultList();
	}

}
