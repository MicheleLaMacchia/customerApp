package com.mlm.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlm.customer.repository.CustomerRepository;
import com.mlm.customer.repository.model.Customer;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    public List<Customer> customFindAll() {
    	return customerRepository.customFindAllWNativeQuery();
    }
    
    public List<Customer> criteriaFindAll() {
    	return customerRepository.customFindAllWCriteria();
    }
    
    public List<Customer> findBetweenAges(int minAge, int maxAge) {
    	return customerRepository.findCustomersByAgeAndLastName(minAge, maxAge);
    }
    
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Customer update(Customer customer, Long id) {
    	
    	Customer savedCustomer = null;
    	Optional<Customer> actualCustomerOpz = customerRepository.findById(id);
    	
    	if (!actualCustomerOpz.isEmpty()) {
    		
    		Customer actualCustomer = actualCustomerOpz.get();
    		
    		actualCustomer.setFirstName(customer.getFirstName());
    		actualCustomer.setLastName(customer.getLastName());
    		actualCustomer.setFiscalCode(customer.getFiscalCode());
    		actualCustomer.setAge(customer.getAge());
			
    		savedCustomer = customerRepository.save(actualCustomer);
    		
		} 
    	
    	return savedCustomer;
    }
    
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

