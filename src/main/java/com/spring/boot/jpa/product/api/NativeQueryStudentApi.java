package com.spring.boot.jpa.product.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.product.data.JPQLStudent;
import com.spring.boot.jpa.product.repo.JPQLStudentClassRepository;
import com.spring.boot.jpa.product.repo.JPQLStudentRepository;
import com.spring.boot.jpa.product.repo.NativeQueryStudentRepository;

@RestController
@RequestMapping("/native/student")
public class NativeQueryStudentApi {

	 @PersistenceContext
	 private EntityManager entityManager;

	@Autowired
	private JPQLStudentRepository repository;
	
	@Autowired
	private JPQLStudentClassRepository classRepository;
	
	@Autowired
	private NativeQueryStudentRepository nativeRepository;
	
	
	@GetMapping("/all")
	public List<JPQLStudent> findAllStudentsNQ() {
		return nativeRepository.findAllStudentsNQ();
	}
	
	@GetMapping("/names/all")
	public List<Object[]> findAllStudentNames() {
		return nativeRepository.findAllStudentNames();
	}
	
	@GetMapping("/marks/{marks}")
	public List<JPQLStudent> findByMarksNQ(@PathVariable int marks) {
		return nativeRepository.findByMarksNQ(marks);
	}
	
	@PostMapping("/insert")
	public List<JPQLStudent> insertandSelectSutdents(@RequestBody JPQLStudent student) {
		student.setId(nativeRepository.findMaxEmpId() + 1);
		classRepository.insertStudent(student);
		return repository.findAllStudents();
	}
	
	@DeleteMapping("/remove/{id}")
	public List<JPQLStudent> removeStudent(@PathVariable int id) {
		classRepository.removeStudent(id);
		return repository.findAllStudents();
	}
}
