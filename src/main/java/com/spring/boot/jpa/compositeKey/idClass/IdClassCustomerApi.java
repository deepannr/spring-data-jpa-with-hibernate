package com.spring.boot.jpa.compositeKey.idClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compositeKey/idClass")
class IdClassCustomerApi {
	
	@Autowired
	private IdClassCustomerRepository repository;
	
	@PostMapping("/add")
	public List<IdClassCustomer> add(@RequestBody InputData input) {
		IdClassCustomer customer = new IdClassCustomer();
		customer.setId(input.getId());
		customer.setEmail(input.getEmail());
		customer.setName(input.getName());
		repository.save(customer);
		
		return repository.findAll();
	}
}
