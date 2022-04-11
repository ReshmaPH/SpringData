package com.reshma.product.repo;

import java.util.List;



import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.reshma.product.entities.Product;

//public interface ProductRepository extends CrudRepository<Product,Integer>{
public interface ProductRepository extends JpaRepository<Product,Integer>{  //to do paging
	List<Product> findByName(String name); // return type ,method name,arguments
	List<Product> findByNameAndDesc(String name,String desc);
	List<Product> findByPriceGreaterThan(double price);
	List<Product> findByDescContains(String desc);
	List<Product> findByPriceBetween(double price1,double price2);
	List<Product> findByNameLike(String name);
	//List<Product> findByIdIn(List<Integer> ids);
	List<Product> findByIdIn(List<Integer> ids,Pageable pageable); // custom finder methods
	//calling a  stored procedure
	//@Procedure(value="GETALLPRODUCTS")
	@Query(value="{CALL GetAllProducts}",nativeQuery =true)  // the braces are must
	//otherwise will throw error "invalid procedure name"
	List<Product> findAllProducts();
}
