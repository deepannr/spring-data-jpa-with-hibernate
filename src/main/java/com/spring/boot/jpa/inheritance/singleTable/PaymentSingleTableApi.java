package com.spring.boot.jpa.inheritance.singleTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inheritance/singleTable")
public class PaymentSingleTableApi {
	@Autowired
	private PaymentSingleTableReposirory repository;
	
	@PostMapping("/card")
	public Iterable<PaymentSingleTable> processCardPayment(@RequestBody InputData payment) {
		CreditCardSingleTable card = new CreditCardSingleTable();
		card.setId(repository.findMaxId() + 1);
		card.setAmount(payment.getAmount());
		card.setCardNumber(payment.getNumber());
		repository.save(card);
		return repository.findAll();
	}
	
	@PostMapping("/cheque")
	public Iterable<PaymentSingleTable> processChequePayment(@RequestBody InputData payment) {
		ChequeSingleTable cheque = new ChequeSingleTable();
		cheque.setId(repository.findMaxId() + 1);
		cheque.setAmount(payment.getAmount());
		cheque.setChequeNumber(payment.getNumber());
		repository.save(cheque);
		return repository.findAll();
	}
}