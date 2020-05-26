package com.spring.boot.jpa.association.oneToOne;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Integer> {

	@Query("from License")
	List<License> findLicense();
	
	@Query(value = "delete from oo_Person where id=:id", nativeQuery = true)
	void removePersonById(int id);
	
	@Query(value = "Select person.first_name, person.last_name, person.age, license.type from OO_PERSON person, OO_LICENSE license where person.id=license.person_id", nativeQuery = true)
	List<Object[]> findAllLicense();
}