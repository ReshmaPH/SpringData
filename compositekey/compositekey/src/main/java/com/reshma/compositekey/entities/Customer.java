package com.reshma.compositekey.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="customer1")
//@IdClass(CustomerId.class)   
/*composite key can be implemented either by @IdClass or by Embeddable and EmbeddedId*/

public class Customer {
/*@Id
private int id;
@Id
private String email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
*/
	
@EmbeddedId	
private CustomerId id;	
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public CustomerId getId() {
	return id;
}
public void setId(CustomerId id) {
	this.id = id;
}



}
