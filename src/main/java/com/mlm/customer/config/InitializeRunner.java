package com.mlm.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mlm.customer.repository.CustomerRepository;
import com.mlm.customer.service.ProductService;

@Component
public class InitializeRunner implements CommandLineRunner {
	
	@Autowired
	ProductService productService;

	@Autowired
	CustomerRepository customerRepository;
	
    @Override
    public void run(String... args) throws Exception {
        
    	System.out.println("## Prodotti presenti nel db:");
    	productService.findAll()
    		.forEach(System.out::println);
    	
    	System.out.println("## Clienti presenti nel db:");
    	customerRepository.findAll()
    		.forEach(System.out::println);
        
    }
    
    
    
}
