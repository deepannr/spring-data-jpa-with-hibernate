package com.spring.boot.jpa.compositeKey.embed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compositeKey/embed")
class EmbedCustomerApi {
	
	@Autowired
	private EmbedCustomerRepository repository;
	
	@PostMapping("/add")
	public List<EmbedCustomer> add(@RequestBody InputData input) {
		EmbedCustomerId embed = new EmbedCustomerId();
		embed.setId(input.getId());
		embed.setEmail(input.getEmail());
		
		EmbedCustomer customer = new EmbedCustomer();
		customer.setCustomer(embed);
		customer.setName(input.getName());
		repository.save(customer);
		
		return repository.findAll();
	}
}
