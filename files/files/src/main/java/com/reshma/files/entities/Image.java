package com.reshma.files.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {
	
@Id
@GeneratedValue
private int id;
private String name;
@Lob
private byte data[];

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
public byte[] getData() {
	return data;
}
public void setData(byte[] data) {
	this.data = data;
}


}
