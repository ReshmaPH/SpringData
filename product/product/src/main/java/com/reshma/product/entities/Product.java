package com.reshma.product.entities;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
/*@NamedStoredProcedureQuery(name = "Product.getallproducts",procedureName = "GETALLPRODUCTS",parameters= 
{
		@StoredProcedureParameter(mode=ParameterMode.OUT,name="id",type=Integer.class),
		@StoredProcedureParameter(mode=ParameterMode.OUT,name="name",type=String.class),
		@StoredProcedureParameter(mode=ParameterMode.OUT,name="description",type=String.class),
		@StoredProcedureParameter(mode=ParameterMode.OUT,name="price",type=Double.class)
})*/  //trying to invoke stored procedure
public class Product implements Serializable {   // serializable to store cache data into disk. second level caching
	
	@Id
	private int id;
	private String name;
	@Column(name="description")
	private String desc;
	private double price;
	
	
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
	}
	
	
	
}
