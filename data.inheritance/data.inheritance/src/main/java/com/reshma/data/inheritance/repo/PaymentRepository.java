package com.reshma.data.inheritance.repo;

import org.springframework.data.repository.CrudRepository;

import com.reshma.data.inheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
