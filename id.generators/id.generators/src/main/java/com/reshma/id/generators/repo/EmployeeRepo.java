package com.reshma.id.generators.repo;

import org.springframework.data.repository.CrudRepository;

import com.reshma.id.generators.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long>{

}
