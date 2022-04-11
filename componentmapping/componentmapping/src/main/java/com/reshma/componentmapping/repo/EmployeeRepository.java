package com.reshma.componentmapping.repo;

import org.springframework.data.repository.CrudRepository;

import com.reshma.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
