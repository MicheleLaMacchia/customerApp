package com.mlm.customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mlm.customer.dto.CustomerDTO;

@SpringBootTest
class CustomerApplicationTests {

	@Test
	void contextLoads() {
		
		CustomerDTO c = new CustomerDTO();
		System.out.println(c);
	}

}
