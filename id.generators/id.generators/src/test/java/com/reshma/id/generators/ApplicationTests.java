package com.reshma.id.generators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.id.generators.entities.Employee;
import com.reshma.id.generators.repo.EmployeeRepo;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	EmployeeRepo er;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate() {
		Employee employee = new Employee();
		//employee.setId(123l);
		employee.setName("Resh");
		er.save(employee);
	}
	
}
