package com.spring.boot.jpa.association.manytomany;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
	@Query(value = "SELECT prog.name Programmer, prog.salary Salary, proj.name Project FROM MM_PROGRAMMER prog, MM_PROJECT  proj, MM_PROGRAMMERS_PROJECTS map where proj.id=map.PROJECT_ID and prog.id=map.PROGRAMMER_ID", nativeQuery = true)
	List<Object[]> findAllDetails();
}
