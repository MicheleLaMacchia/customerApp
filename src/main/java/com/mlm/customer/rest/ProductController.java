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

import com.mlm.customer.repository.model.Product;
import com.mlm.customer.service.ProductService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	
    @Autowired
    private ProductService productService;
    
    @RequestMapping(path = "insert-product", method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @RequestMapping(path = "products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(path = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isEmpty()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
    	Product updatedproduct = productService.update(product, id);
        if (updatedproduct != null) {
            return new ResponseEntity<>(updatedproduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
    	Optional<Product> product = productService.findById(id);
        if (!product.isEmpty()) {
        	productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
