package com.spring.boot.jpa.miniProj.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.spring.boot.jpa.miniProj.data.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	@Query("from Patient u WHERE u.firstName LIKE CONCAT('%', :keyword, '%') OR u.lastName LIKE CONCAT('%', :keyword, '%')")
	Patient findAllPatientsByName(@Param("keyword") String name);
}
