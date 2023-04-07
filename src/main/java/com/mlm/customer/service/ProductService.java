package com.mlm.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlm.customer.repository.ProductRepository;
import com.mlm.customer.repository.model.Product;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll() {
    	List<Product> list = productRepository.findAll();    	
        return list;
    }
    
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }
    
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public Product update(Product product, String id) {
    	
    	Product savedProduct = null;
    	Optional<Product> actualProductOpz = productRepository.findById(id);
    	
    	if (!actualProductOpz.isEmpty()) {
    		
    		Product actualProduct = actualProductOpz.get();
    		
    		actualProduct.setBarcode(product.getBarcode());
    		actualProduct.setCost(product.getCost());
    		actualProduct.setProductCategory(product.getProductCategory());
    		actualProduct.setProductName(product.getProductName());
			
    		savedProduct = productRepository.save(actualProduct);
    		
		} 
    	
    	return savedProduct;
    }
    
    public void deleteById(String id) {
    	productRepository.deleteById(id);
    }
}

