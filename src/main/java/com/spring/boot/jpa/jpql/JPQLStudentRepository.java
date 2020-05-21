package com.spring.boot.jpa.jpql;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JPQLStudentRepository extends CrudRepository<JPQLStudent, Integer> {

	@Query("from JPQLStudent")
	List<JPQLStudent> findAllStudents();

	@Query("from JPQLStudent u WHERE u.firstName LIKE CONCAT('%', :keyword, '%') OR u.lastName LIKE CONCAT('%', :keyword, '%')")
	List<JPQLStudent> findAllStudentsByFirstName(@Param("keyword") String fName);

	@Query("Select st.firstName, st.lastName from JPQLStudent st")
	List<Object[]> findAllStudentNames();

	@Query("from JPQLStudent where score>=:score order by score desc")
	List<JPQLStudent> findByStudentMarks(@Param("score") int marks);
	
	@Query("from JPQLStudent where score between :from and :to order by score desc")
	List<JPQLStudent> findByStudentMarksBetween(@Param("from") int fromMark, @Param("to") int toMark);
	
	@Modifying
	@Query("delete from JPQLStudent where id=:studId")
	void removeStudent(@Param("studId") int id);

	@Query("from JPQLStudent where score between :from and :to order by score desc")
	List<JPQLStudent> findByStudentMarksBetweenPageable(@Param("from") int fromMark, @Param("to") int toMark, Pageable pageable);
	
	@Query("from JPQLStudent where score>=:score")
	List<JPQLStudent> findByStudentMarksDirection(@Param("score") int marks, Pageable pageable);
	
	@Query("from JPQLStudent where score>=:score")
	List<JPQLStudent> findByStudentMarksSort(@Param("score") int marks, Pageable pageable);
}