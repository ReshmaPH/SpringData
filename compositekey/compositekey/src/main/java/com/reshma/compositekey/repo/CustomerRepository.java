package com.reshma.compositekey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reshma.compositekey.entities.Customer;
import com.reshma.compositekey.entities.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {

}
