package com.spring.boot.jpa.product.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.product.data.JPQLStudent;

@Repository
public class JPQLStudentClassRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertStudent(JPQLStudent student) {
		entityManager.createNativeQuery("Insert into Student (stud_id, f_Name, l_Name, score) values (?, ?, ?, ?)")
				.setParameter(1, student.getId())
				.setParameter(2, student.getFirstName())
				.setParameter(3, student.getLastName())
				.setParameter(4, student.getMarks())
				.executeUpdate();
	}
	
	@Transactional
	public void removeStudent(int id) {
		entityManager.createNativeQuery("Delete from Student where stud_id = " + id).executeUpdate();
	}
}
