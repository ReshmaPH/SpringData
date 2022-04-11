package com.reshma.data.inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.data.inheritance.entities.Check;
import com.reshma.data.inheritance.entities.CreditCard;
import com.reshma.data.inheritance.repo.PaymentRepository;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateCardPayment() {
		CreditCard cc=new CreditCard();
		cc.setAmount(1000);
		cc.setCardnumber("ADEC1256");
		repository.save(cc);
		
	}
	
	@Test
	void testCreateCheckPayment() {
		Check ch=new Check();
		ch.setAmount(2000);
		ch.setChecknumber("DFRGHTYUOK1");  // if we set check number
										//it will automatically select ch pmode as we have set discriminatory value in check table
		repository.save(ch);
	}

}
