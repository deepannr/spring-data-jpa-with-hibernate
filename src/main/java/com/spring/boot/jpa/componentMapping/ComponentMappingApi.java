package com.spring.boot.jpa.componentMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/componentMapping")
class ComponentMappingApi {

	@Autowired
	private ComponentMappingRepository repository;

	@PostMapping("/insert")
	public Iterable<ComponentMappingEmployee> insertEmployee(@RequestBody InputData input) {
		Address address = new Address(input.getStreetAddress(), input.getCity(), input.getZipCode(), input.getState(),
				input.getCountry());

		ComponentMappingEmployee employee = new ComponentMappingEmployee(repository.findMaxValue() + 1, input.getName(), address);

		repository.save(employee);
		return repository.findAll();
	}
}
