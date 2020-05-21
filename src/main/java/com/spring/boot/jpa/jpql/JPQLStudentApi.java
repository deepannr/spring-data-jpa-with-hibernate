package com.spring.boot.jpa.jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpql/student")
public class JPQLStudentApi {
	@Autowired
	private JPQLStudentRepository repository;

	@GetMapping("/all")
	public List<JPQLStudent> findAllStudents() {
		return repository.findAllStudents();
	}

	@GetMapping("/all/{fName}")
	public List<JPQLStudent> findAllStudentsByName(@PathVariable String fName) {
		return repository.findAllStudentsByFirstName(fName);
	}

	@GetMapping("/names/all")
	public List<Object[]> findAllStudentNames() {
		return repository.findAllStudentNames();
	}

	@GetMapping("/find/marks/{mark}")
	public List<JPQLStudent> findByStudentMarks(@PathVariable int mark) {
		return repository.findByStudentMarks(mark);
	}

	@GetMapping("/between/marks/{fromMarks}/{toMarks}")
	public List<JPQLStudent> findByStudentMarksBetween(@PathVariable int fromMarks, @PathVariable int toMarks) {
		return repository.findByStudentMarksBetween(fromMarks, toMarks);
	}
	
	@GetMapping("/between/marks/pageable")
	public List<JPQLStudent> findByStudentMarksBetweenPageable(@RequestBody StudentMarksBetweenPageable request) {
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
		return repository.findByStudentMarksBetweenPageable(request.getFromMarks(), request.getToMarks(), pageable);
	}
	
	@GetMapping("/marks/direction")
	public List<JPQLStudent> findByStudentMarksDirection(@RequestBody StudentMarksBetweenPageable request) {
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Direction.ASC, "marks");
		return repository.findByStudentMarksDirection(request.getFromMarks(), pageable);
	}
	
	@GetMapping("/marks/sort")
	public List<JPQLStudent> findByStudentMarksSort(@RequestBody StudentMarksBetweenPageable request) {
		Sort.Order nameOrder = new Sort.Order(Direction.ASC, "firstName");
		Sort.Order markOrder = new Sort.Order(Direction.DESC, "marks");
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(markOrder, nameOrder));
		return repository.findByStudentMarksSort(request.getFromMarks(), pageable);
	}
}
