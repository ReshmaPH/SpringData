package com.reshma.jpaassociations.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/* In many to many associations entities 
 * will be connected by list or set of other associated entities and corresponding
 * tables will be linked by another joined table  here the prorammers_projects
 * connection is established by @JoinTable annotation
 * create table programmer(
id int PRIMARY KEY, 
name varchar(20),
salary int
)

create table project(
id int PRIMARY KEY,
name varchar(20)
)

create table programmers_projects(
programmer_id int,
project_id int,
FOREIGN KEY (programmer_id)
REFERENCES programmer(id),
FOREIGN KEY (project_id)
REFERENCES project(id)
) 
 */
@Entity
public class Programmer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int salary;
	
	@ManyToMany(cascade = CascadeType.ALL)
	
	@JoinTable(name ="programmers_projects",   // name of join table
	joinColumns = @JoinColumn(name="programmer_id",referencedColumnName = "id"),  //one side
	inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "id")) //other side of relationship
	
	private Set<Project> projects;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
