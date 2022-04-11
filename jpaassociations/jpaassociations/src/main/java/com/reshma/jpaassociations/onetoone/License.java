package com.reshma.jpaassociations.onetoone;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class License {
@Id
@GeneratedValue
private int id;
//private int person_id;  this can mark using annotations as it is the foreign key in table
private String vehicletype;
@Temporal(TemporalType.DATE)
private Date valid_from;
@Temporal(TemporalType.DATE)
private Date valid_to;
@OneToOne(cascade = CascadeType.ALL) // ALL : - if the person is deleted or updated , the license info also wil be affected in same way
@JoinColumn(name ="person_id")
private Person person;


public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getVehicletype() {
	return vehicletype;
}



public void setVehicletype(String vehicletype) {
	this.vehicletype = vehicletype;
}



public Date getValid_from() {
	return valid_from;
}



public void setValid_from(Date valid_from) {
	this.valid_from = valid_from;
}



public Date getValid_to() {
	return valid_to;
}



public void setValid_to(Date valid_to) {
	this.valid_to = valid_to;
}



public Person getPerson() {
	return person;
}



public void setPerson(Person person) {
	this.person = person;
}



@Override
public String toString() {
	return "License [id=" + id + ", type=" + vehicletype + ", valid_from=" + valid_from
			+ ", valid_to=" + valid_to + "]";
}


}
