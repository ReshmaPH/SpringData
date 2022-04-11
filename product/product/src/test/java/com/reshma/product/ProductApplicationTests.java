package com.reshma.product;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.Assert;

import com.reshma.product.entities.Product;
import com.reshma.product.repo.ProductRepository;

@SpringBootTest



class ProductApplicationTests {
	
	@Autowired
	EntityManager entityManager;  // jpa equivalant of hibernate session entity manager
	@Autowired
	ProductRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testCreate() {
		Product product=new Product();
		//product.setId(1);
		product.setName("Iphone6s");
		product.setDesc("Awsome");
		product.setPrice(100d);
		repository.save(product);
	}
	
	@Test
	void testRead() {
		Product product=repository.findById(1).get(); //returns optional thats why get
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	
	@Test
	void testUpdate() {
		Product product=repository.findById(1).get();
		product.setPrice(1000d);
		repository.save(product);
	}
	
	@Test
	void testDelete() {
		Product product=repository.findById(1).get();
		repository.delete(product);
	}
	
	@Test
	void testDeleteIfExists() {
		if(repository.existsById(1)) {
		repository.deleteById(1);
		}
	}
	
	@Test
	void testFindByName() {
		List<Product> product = repository.findByName("Iwatch");
		product.forEach(p-> System.out.println(p.getPrice()));
	}
	
	@Test
	void testFindByNameAndDesc() {
		List<Product> product = repository.findByNameAndDesc("Iwatch","from_apple");
		product.forEach(p-> System.out.println(p.getPrice()));
	}
	
	@Test
	void testFindByPriceGreaterThan() {
		List<Product> product = repository.findByPriceGreaterThan(100);
		product.forEach(p-> System.out.println(p.getPrice()));
	}
	
	@Test
	void testFindByDescContains() {
		List<Product> product=repository.findByDescContains("samsung");
		product.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testFindByPriceBetween() {
		List<Product> product=repository.findByPriceBetween(300,700);
		product.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testFindByNameLike() {
		List<Product> product=repository.findByNameLike("Iph%");
		product.forEach(p->System.out.println(p.getName()));
	}
	/*
	@Test
	void testFindByIdIn() {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		List<Product> product=repository.findByIdIn(list);
		product.forEach(p->System.out.println(p.getName()));
	}
	*/
	@Test
	void testFindAllPaging() {
		PageRequest pageable=PageRequest.of(0, 2);  // here 0:page number, 2 no of records per page
		Page<Product> result = repository.findAll(pageable);
		result.forEach(p->System.out.println(p.getName()));		
	}
	
	@Test
	void testFindAllSortingByName() {
		repository.findAll(Sort.by("name")).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testFindAllSortingByNameDesc() {
		repository.findAll(Sort.by(Direction.DESC, "name")).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testFindAllSortingByNameAndPriceDesc() {
		repository.findAll(Sort.by(Direction.DESC, "name","price")).forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testPagingAndSorting() {
		PageRequest pageable=PageRequest.of(0, 2, Direction.DESC, "name");
		Page<Product> result = repository.findAll(pageable);
		result.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	void testFindByIdIn() {
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Pageable pageable=PageRequest.of(0,2); 
	repository.findByIdIn(list, pageable).forEach(p->System.out.println(p.getName()));
		
	}
	
	//chaching testing..hibernate has 2 levels of cache
	//..1.session 2.session factory. to enbale them in spring data use @transactional
	@Test
	@Transactional
	void testCache() {
		Session session = entityManager.unwrap(Session.class);
		
		Product product = repository.findById(1).get();  // fetch details from db and store it in cache
		repository.findById(1);  // get it from cache
		session.evict(product);  //remove from cache
		repository.findById(1);  //from table again
	}
	
	/*EH cache , a cache provider for hibernate level 2 cache.to use it
	 *Add mavan repo for that in pom.xml
	 *enable it in application.properties
	 * create encache.xml
	 * mark entities to be cached
	 * test
	 */
	/* 
	 * if sec level cache is enabled , the above test will fetch data from db only once.even if it is evicted from first level cache it will be in disk sec level*/


	@Test
	void testfindAllProducts() {
		System.out.println(repository.findAllProducts());
	}

}

