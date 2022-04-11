package com.reshma.transactionmanagement.transactionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reshma.transactionmanagement.transactionmanagement.entities.BankAccount;

public interface BankAccountRepo extends JpaRepository<BankAccount,Integer>{

}
