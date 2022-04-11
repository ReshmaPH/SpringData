package com.reshma.data.inheritance.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// There are 2 payment types credit and check. so we create 3 classes with common fields in parent table payment and 
//unique fields in child tables check and credit card. Make parent table abstract so it can not be used directly.
//@Inheritance annotation from jpa tells that what type of strategy we are using to map classes to tables.

/*
 * single table :
 * create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),  //child table credit card
checknumber varchar(20) //child table check
); 
 */

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   -- single table
//@DiscriminatorColumn(name="pmode",discriminatorType = DiscriminatorType.STRING) // if it is single table 
																				//strategy give discriminatory
																				//mention discriminatory value in child tables
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  // fast but normalization is not possible ,, 
														//there will be 2 tables 1st 
														//for card(id,cardnumber) 2nd for check (id,checknumber)
@Inheritance(strategy=InheritanceType.JOINED) // joined- most popular and commonly used  ,3 tables .parent and child
													//are mapped by primary and foreign keys
public abstract class Payment {
	@Id
	@GeneratedValue
	private int id;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
