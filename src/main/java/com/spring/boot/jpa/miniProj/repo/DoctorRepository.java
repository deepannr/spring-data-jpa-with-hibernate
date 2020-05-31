package com.spring.boot.jpa.miniProj.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.spring.boot.jpa.miniProj.data.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	@Query("from Doctor u WHERE u.firstName LIKE CONCAT('%', :keyword, '%') OR u.lastName LIKE CONCAT('%', :keyword, '%')")
	Doctor findAllDoctorByName(@Param("keyword") String name);
}