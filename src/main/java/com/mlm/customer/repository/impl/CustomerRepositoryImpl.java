package com.mlm.customer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mlm.customer.repository.custom.CustomerCustomRepository;
import com.mlm.customer.repository.model.Customer;

public class CustomerRepositoryImpl implements CustomerCustomRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> customFindAllWNativeQuery() {
		
		Query query = entityManager.createNativeQuery("select * from Customers", Customer.class);

		return query.getResultList();
	}

	@Override
	public List<Customer> customFindAllWCriteria() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
	    CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
	    
	    Root<Customer> root = criteriaQuery.from(Customer.class);
	    
	    Predicate agePredicate = criteriaBuilder
	    	.between(root.get("age"), 30, 50);
	    Predicate lastNamePredicate = criteriaBuilder
	    	.equal(root.get("lastName"), "Rossi");

	    criteriaQuery.select(root)
	    	.where(criteriaBuilder
	    	.and(agePredicate, lastNamePredicate));
	    
	    TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);
	    
	   return query.getResultList();

	}

}
