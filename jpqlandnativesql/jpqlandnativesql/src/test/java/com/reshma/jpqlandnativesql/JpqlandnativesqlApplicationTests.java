package com.reshma.jpqlandnativesql;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

@SpringBootTest
class JpqlandnativesqlApplicationTests {
	@Autowired
	StudentRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateStudent() {
		Student student = new Student();
		student.setFirstName("Resh");
		student.setLastName("Ph");
		student.setScore(80);
		repository.save(student);
		
		Student student2 = new Student();
		student2.setFirstName("Sandhu");
		student2.setLastName("VS");
		student2.setScore(90);
		repository.save(student2);
	}
	
	@Test
	void testFindAllStudents() {
	//	List<Student> Students = repository.findAllStudents(PageRequest.of(1, 2)); paging
		List<Student> Students = repository.findAllStudents(PageRequest.of(1, 2,Direction.DESC,"id"));//paging and sorting
		for(Student s:Students) {
			System.out.println(s);
		}
	}
		
	@Test
		void testFindAllStudentsPartial() {
			List<Object> students = repository.findAllStudentsPartial();
			for(Object s:students) {
				System.out.println(s);
			}
	}
	
	@Test
	void testFindAllStudentsByFirstName() {
		List<Student> Students = repository.findAllStudentsByFirstName("Resh");
		for(Student s:Students) {
			System.out.println(s);
		}
	}
	
	@Test
	void testfindAllStudentsForGivenScoreRange() {
		List<Student> Students = repository.findAllStudentsForGivenScoreRange(70,85);
		for(Student s:Students) {
			System.out.println(s);
		}
	}
	
	@Test
	void testdeleteStudentByFirstName() {
		repository.deleteStudentByFirstName("Resh");
	}
	
	@Test
	void testfindAllStudentss() {
		repository.findAllStudentss().forEach(p->System.out.println(p.FirstName));
	}
	
	@Test
	void testfindAllStudentsByFirstNamee() {
		List<Student> students =repository.findAllStudentsByFirstNamee("Ph");
		for(Student s:students) {
			System.out.println(s);
		}
	}

}
