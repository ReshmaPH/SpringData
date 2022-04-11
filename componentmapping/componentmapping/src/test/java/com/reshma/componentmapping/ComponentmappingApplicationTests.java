package com.reshma.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.componentmapping.entities.Address;
import com.reshma.componentmapping.entities.Employee;
import com.reshma.componentmapping.repo.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateEmployee() {
		Employee employee=new Employee();
		employee.setName("Resh");
		Address address =new Address();
		address.setCity("Thrissur");
		address.setCountry("India");
		address.setState("Kerala");
		address.setStreetaddress("Parappukkara");
		address.setZipcode("680312");
		employee.setAddress(address);
		repository.save(employee);
		
	}

}
