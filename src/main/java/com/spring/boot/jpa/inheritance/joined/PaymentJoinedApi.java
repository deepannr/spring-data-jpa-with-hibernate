package com.spring.boot.jpa.inheritance.joined;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inheritance/joined")
public class PaymentJoinedApi {
	@Autowired
	private PaymentJoinedRepository repository;
	
	@PostMapping("/card")
	public List<PaymentJoined> processCardPayment(@RequestBody InputData payment) {
		CreditCardJoined card = new CreditCardJoined();
		card.setId(repository.findMaxId() + 1);
		card.setAmount(payment.getAmount());
		card.setCardNumber(payment.getNumber());
		repository.save(card);
		return repository.selectCreditCard();
	}
	
	@PostMapping("/cheque")
	public List<PaymentJoined> processChequePayment(@RequestBody InputData payment) {
		ChequeJoined cheque = new ChequeJoined();
		cheque.setId(repository.findMaxId() + 1);
		cheque.setAmount(payment.getAmount());
		cheque.setChequeNumber(payment.getNumber());
		repository.save(cheque);
		return repository.selectCheque();
	}
}
