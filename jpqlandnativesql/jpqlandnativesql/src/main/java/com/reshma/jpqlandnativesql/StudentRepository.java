package com.reshma.jpqlandnativesql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("from Student") // Student is jpa class/Entity name
	//List<Student> findAllStudents();  for paging use below
	List<Student> findAllStudents(Pageable pageable);
	@Query("select FirstName from Student")
	List<Object> findAllStudentsPartial();
	@Query("from Student where FirstName=:firstName")  //  Named Query,Parameter search
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentsForGivenScoreRange(@Param("min") double min,@Param("max") double max);
	@Transactional  // use these two for modifying a table
	@Modifying
	@Query("delete from Student where FirstName=:firstName")
	void deleteStudentByFirstName(@Param("firstName") String firstName);
	//jpql doesnt support ddl .. 
	//if you use native query
	@Query(value="select *from student",nativeQuery = true)
	List<Student> findAllStudentss();
	@Query(value="select *from student where fname=:firstName",nativeQuery = true)
	List<Student> findAllStudentsByFirstNamee(@Param("firstName") String Firstname);
	
}
