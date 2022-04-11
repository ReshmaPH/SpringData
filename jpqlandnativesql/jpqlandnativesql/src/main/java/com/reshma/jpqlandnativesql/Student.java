package com.reshma.jpqlandnativesql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
@Column(name="fname")
String FirstName;
@Column(name="lname")
String LastName;
double score;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}

@Override
public String toString() {
	return "Student [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", score=" + score + "]";
}



}
