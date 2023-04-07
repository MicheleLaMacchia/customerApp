package com.mlm.customer.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mlm.customer.dto.CustomerDTO;
import com.mlm.customer.repository.model.Customer;
import com.mlm.customer.service.CustomerService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(path = "insert-customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @RequestMapping(path = "customers", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(path = "customers/between/{minAge}/{maxAge}", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomersBetweenAges(
    		@PathVariable(name = "minAge") int minAge, 
    		@PathVariable(name = "maxAge") int maxAge) {
    	List<Customer> customers = customerService.findBetweenAges(minAge, maxAge);
    	return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(path = "custom-native/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> customGetAllCustomers() {
    	List<Customer> customers = customerService.customFindAll();
    	return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    @RequestMapping(path = "custom-criteria/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> criteriaGetAllCustomers() {
    	List<Customer> customers = customerService.criteriaFindAll();
    	return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(path = "customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isEmpty()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.update(customer, id);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    	Optional<Customer> customer = customerService.findById(id);
        if (!customer.isEmpty()) {
        	customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
