package com.reshma.transactionmanagement.transactionmanagement.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")
public class BankAccount{  
	@Id
	private int accno;
	@Column(name="lastname")
	private String lastName;
	@Column(name="firstname")
	private String firstName;
	private int bal;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", lastName=" + lastName + ", firstName=" + firstName + ", bal=" + bal
				+ "]";
	}
	
	
}
