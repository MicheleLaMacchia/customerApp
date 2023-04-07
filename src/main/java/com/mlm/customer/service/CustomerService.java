package com.mlm.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlm.customer.dto.CustomerDTO;
import com.mlm.customer.repository.CustomerProductRepository;
import com.mlm.customer.repository.CustomerRepository;
import com.mlm.customer.repository.model.Customer;
import com.mlm.customer.repository.model.Product;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerProductRepository customerProductRepository;
    
    public List<CustomerDTO> findAll() {
    	
    	List<Customer> list = customerRepository.findAll();
    	List<CustomerDTO> listDTO = new ArrayList<CustomerDTO>();
    	
    	list.forEach(c -> {
    		List<Product> products = customerProductRepository.findProductsByCustomerId(c.getId());
    		CustomerDTO cDTO = CustomerDTO.fromEntity(c, products);
    		listDTO.add(cDTO);
    	});
    	
        return listDTO;
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

