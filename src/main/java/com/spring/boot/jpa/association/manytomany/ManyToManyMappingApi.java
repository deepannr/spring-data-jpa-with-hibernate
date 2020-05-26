package com.spring.boot.jpa.association.manytomany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association/manyToMany")
class ManyToManyMappingApi {
	
	@Autowired
	private ProgrammerRepository repository;
	
	@PostMapping("/insert")
	public List<Object[]> insert(@RequestBody InputData input) {
		Set<Project> projectSet = new HashSet<>();
		input.getProjectNames().forEach(projectString -> {
			Project project = new Project();
			project.setName(projectString);
			projectSet.add(project);
		});
		Programmer programmer = new Programmer();
		programmer.setName(input.getProgrammerName());
		programmer.setSalary(input.getProgrammerSalary());
		programmer.setProjects(projectSet);
		
		repository.save(programmer);
		return repository.findAllDetails();
	}
	
}
