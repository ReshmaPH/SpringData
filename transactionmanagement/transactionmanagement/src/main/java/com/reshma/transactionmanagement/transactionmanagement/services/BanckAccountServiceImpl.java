package com.reshma.transactionmanagement.transactionmanagement.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reshma.transactionmanagement.transactionmanagement.entities.BankAccount;
import com.reshma.transactionmanagement.transactionmanagement.repo.BankAccountRepo;

@Service
public class BanckAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepo repository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount obamasacct = repository.findById(1).get();
		obamasacct.setBal(obamasacct.getBal()-amount);
		repository.save(obamasacct);
		// use @transactional so that incase any of the transactions 
		//fails all changes inside this function will be rolled back
		BankAccount trumpsacct = repository.findById(2).get();
		trumpsacct.setBal(trumpsacct.getBal()+amount);
		repository.save(trumpsacct);

	}

}
