package com.reshma.jpaassociations.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/* One customer has many phone numbers 
 * ie onetomany relation 
 * so here customer has a set of PhoneNumber objects and PhoneNumber class has a field with type of Customer.
 * table connection is established by foreign key @JoinColumn
 */

/*cascading is actually propagating non select operations from main object to child.
 * persist - only insert
 * merge -insert and update
 * remove - delete
 */

/*
 * Eager loading - child object is loading immediately when parent is loaded
 * lazzy loading- child is loaded on demand
 */

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch = FetchType.EAGER)  //if you do not mention cascade data will not be added to phone number table. 
	private Set<PhoneNumber> phoneNumbers;
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addPhoneNumber(PhoneNumber number) {
		if(number!=null) {
			if(phoneNumbers==null) {
				phoneNumbers=new HashSet<>();
			}
			number.setCustomer(this);//whoever calls this function ,the number is belonged to that customer
			phoneNumbers.add(number);
		}
		
	}
	

}
