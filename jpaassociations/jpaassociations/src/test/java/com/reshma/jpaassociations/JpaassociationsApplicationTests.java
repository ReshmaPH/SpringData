package com.reshma.jpaassociations;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reshma.jpaassociations.manytomany.Programmer;
import com.reshma.jpaassociations.manytomany.Project;
import com.reshma.jpaassociations.onetomany.Customer;
import com.reshma.jpaassociations.onetomany.CustomerRepository;
import com.reshma.jpaassociations.onetomany.PhoneNumber;
import com.reshma.jpaassociations.onetomany.ProgrammerRepository;
import com.reshma.jpaassociations.onetoone.License;
import com.reshma.jpaassociations.onetoone.LicenseRepository;
import com.reshma.jpaassociations.onetoone.Person;


@SpringBootTest
class JpaassociationsApplicationTests {

	@Autowired
	CustomerRepository repository;
	@Autowired
	ProgrammerRepository programmerRepository;
	@Autowired
	LicenseRepository licenseRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateCustomer() {
		Customer customer=new Customer();
		customer.setName("Sandhu");
		PhoneNumber phone1=new PhoneNumber();
		phone1.setPhone_number("23456789");
		phone1.setType("personal");
		PhoneNumber phone2=new PhoneNumber();
		phone2.setPhone_number("239999999");
		phone2.setType("home");
//		Set<PhoneNumber> phonenumbers = new HashSet<PhoneNumber>();
//		phonenumbers.add(phone1);
//		phonenumbers.add(phone2);
//		//customer.setPhoneNumbers(phonenumbers); there is better way of setting forign key
//		
		customer.addPhoneNumber(phone2);
		customer.addPhoneNumber(phone1);
		repository.save(customer);	
	}
	
	@Test
	@Transactional  // to make lazy loading work. otherwise fetch attribute need to set as eager
	void testLoadCustomer() {
		Optional<Customer> customer = repository.findById(47);
		System.out.println(customer.get().getName());
		customer.get().getPhoneNumbers().forEach(p->System.out.println(p.getPhone_number()));
	}
	
	@Test
	void testUpdateCustomer() { //if you get exceptions related lazy loading add fetch type as Eager in customer class file
		Customer customer=repository.findById(47).get();
		customer.setName("Reshma");	
		customer.getPhoneNumbers().forEach(p->p.setType("home"));
		repository.save(customer);	
	}
	
	@Test
	void testDeleteCustomer() {
		repository.deleteById(47);
	}
	//testing many to many mapping
	@Test
	void testCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Resh");
		programmer.setSalary(1000);
		HashSet<Project> projects = new HashSet<>();
		Project p1=new Project();
		p1.setName("Spring boot");
		projects.add(p1);
		Project p2=new Project();
		p2.setName("Spring data");
		projects.add(p2);
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
	}
	
	@Test
	void testLoadProgrammer() {
		Programmer programmer = programmerRepository.findById(61).get();
		System.out.println(programmer);	
	}
	
	@Test
	@Transactional
	void testLoadProjects() {
		Programmer programmer = programmerRepository.findById(61).get();
		System.out.println(programmer);	
		System.out.println(programmer.getProjects());	 // use @transactional to avpoid lazzy loading error	
	}
	
	// test cases  for one to one associations.
	
	@Test
	void testCreateLicense() {
		Person person = new Person();
		person.setAge(30);
		person.setFirst_name("Shivana");
		person.setLast_name("Sandeep");
		License license = new License();
		license.setVehicletype("Car");
		license.setValid_from(new Date());
		license.setValid_to(new Date());
		license.setPerson(person);
		licenseRepository.save(license);
		
	}

}
