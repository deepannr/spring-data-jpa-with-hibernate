package com.spring.boot.jpa.product.nativeQuery;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NativeQueryStudentRepository extends CrudRepository<NativeStudent, Integer> {
	
	@Query(value = "select max(stud_id) maxId from student", nativeQuery = true)
	int findMaxEmpId();
	
	@Query(value = "select * from Student order by f_Name desc", nativeQuery = true)
	List<NativeStudent> findAllStudentsNQ();
	
	@Query(value = "Select st.stud_id, st.f_Name, st.l_Name from Student st order by st.f_name", nativeQuery = true)
	List<Object[]> findAllStudentNames();
	
	@Query(value = "select * from Student where score >= :marks", nativeQuery = true)
	List<NativeStudent> findByMarksNQ(@Param("marks") int score);
}
