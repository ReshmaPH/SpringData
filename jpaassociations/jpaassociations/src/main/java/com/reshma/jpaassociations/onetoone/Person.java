package com.reshma.jpaassociations.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
@Id
@GeneratedValue
private int id;
private int age;
private String first_name;
private String last_name;
@OneToOne(mappedBy = "person")
private License license;
public License getLicense() {
	return license;
}
public void setLicense(License license) {
	this.license = license;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
@Override
public String toString() {
	return "Person [id=" + id + ", age=" + age + ", first_name=" + first_name + ", last_name=" + last_name + "]";
}



}
