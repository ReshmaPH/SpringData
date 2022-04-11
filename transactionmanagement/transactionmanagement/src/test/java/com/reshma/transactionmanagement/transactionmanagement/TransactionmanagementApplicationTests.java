package com.reshma.transactionmanagement.transactionmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.transactionmanagement.transactionmanagement.repo.BankAccountRepo;
import com.reshma.transactionmanagement.transactionmanagement.services.BankAccountService;

@SpringBootTest
class TransactionmanagementApplicationTests {
	
@Autowired
BankAccountService service1;

//@Autowired
//BankAccountRepo repo;

	@Test
	void contextLoads() {
		service1.transfer(500);
	}
	
/*	@Test
	void testRead() {
		repo.findById(1);
	}
*/	
}

