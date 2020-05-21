package com.spring.boot.jpa.product.nativeQuery;

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

@RestController
@RequestMapping("/native/student")
public class NativeQueryStudentApi {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private NativeQueryStudentClassRepository classRepository;
	
	@Autowired
	private NativeQueryStudentRepository nativeRepository;
	
	
	@GetMapping("/all")
	public List<NativeStudent> findAllStudentsNQ() {
		return nativeRepository.findAllStudentsNQ();
	}
	
	@GetMapping("/names/all")
	public List<Object[]> findAllStudentNames() {
		return nativeRepository.findAllStudentNames();
	}
	
	@GetMapping("/marks/{marks}")
	public List<NativeStudent> findByMarksNQ(@PathVariable int marks) {
		return nativeRepository.findByMarksNQ(marks);
	}
	
	@PostMapping("/insert")
	public List<NativeStudent> insertandSelectSutdents(@RequestBody NativeStudent student) {
		student.setId(nativeRepository.findMaxEmpId() + 1);
		classRepository.insertStudent(student);
		return nativeRepository.findAllStudentsNQ();
	}
	
	@DeleteMapping("/remove/{id}")
	public List<NativeStudent> removeStudent(@PathVariable int id) {
		classRepository.removeStudent(id);
		return nativeRepository.findAllStudentsNQ();
	}
}
