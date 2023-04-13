package com.mlm.customer;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.mlm.customer.dto.CustomerDTO;

@SpringBootTest
class CustomerApplicationTests {
	
	@Autowired
    ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		
		CustomerDTO c = new CustomerDTO();
		System.out.println(c);
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
	}

}
