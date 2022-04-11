package com.reshma.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.compositekey.entities.Customer;
import com.reshma.compositekey.entities.CustomerId;
import com.reshma.compositekey.repo.CustomerRepository;

@SpringBootTest
class CompositekeyApplicationTests {
	
	@Autowired
	CustomerRepository repository;
	/*
	 case for @IdClass
	@Test
	void testSaveCustomer() {
		Customer customer=new Customer();
		customer.setId(2);
		customer.setEmail("sandeep@gmail.com");
		customer.setName("Sandhu");
		repository.save(customer);
		
		}
*/
	@Test
	void testSaveCustomer() {
		Customer customer=new Customer();
		CustomerId id=new CustomerId();
		id.setId(3);
		id.setEmail("appu@gmail.com");
		customer.setId(id);
		customer.setName("Appu");
		repository.save(customer);
	}
}
