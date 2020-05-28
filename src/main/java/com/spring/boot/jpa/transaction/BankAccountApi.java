package com.spring.boot.jpa.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactionManagement")
class BankAccountApi {

	@Autowired
	private BankAccountRepository repository;

	@Autowired
	private BankAccountService service;

	@PostMapping("/transfer/{amount}")
	public Iterable<BankAccount> transfer(@PathVariable int amount) {
		service.transfer(amount);
		return repository.findAll();
	}
}
