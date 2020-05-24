package com.spring.boot.jpa.association.onetomany;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association/oneToMany")
class OMCustomerApi {
	@Autowired
	private OMCustomerRepository repository;

	@PostMapping("/insert")
	public List<Object[]> oneToMany(@RequestBody InputData input) {
		OMCustomer customer = new OMCustomer();
		customer.setName(input.getName());
		input.getNumbers().forEach(number -> {
			customer.addPhoneNumber(number);
		});
		repository.save(customer);
		Optional<OMCustomer> optCust = repository.findById(1);
		OMCustomer cust = optCust.get();
		System.out.println(cust.getName());
		System.out.println(cust.getNumbers());
		return repository.findAllCustomer();
	}
	
	@DeleteMapping("/remove/{id}")
	public List<Object[]> oneToMany(@PathVariable int id) {
		repository.deleteById(id);
		return repository.findAllCustomer();
	}
}
