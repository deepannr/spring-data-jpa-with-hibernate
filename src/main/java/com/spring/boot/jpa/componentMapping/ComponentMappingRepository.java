package com.spring.boot.jpa.componentMapping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ComponentMappingRepository extends CrudRepository<ComponentMappingEmployee, Integer> {
	@Query(value = "Select COALESCE(max(id), 0) maxId from Component_Mapping_Employee", nativeQuery = true)
	int findMaxValue();
}
