package com.spring.boot.jpa.inheritance.tablePerClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inheritance/tablePerClass")
public class PaymentTablePerClassApi {
	@Autowired
	private PaymentTablePerClassRepository repository;
	
	@PostMapping("/card")
	public Iterable<PaymentTablePerClass> processCardPayment(@RequestBody InputData payment) {
		CreditCardTablePerClass card = new CreditCardTablePerClass();
		card.setId(repository.findMaxCreditCard() + 1);
		card.setAmount(payment.getAmount());
		card.setCardNumber(payment.getNumber());
		repository.save(card);
		return repository.selectCreditCard();
	}
	
	@PostMapping("/cheque")
	public Iterable<PaymentTablePerClass> processChequePayment(@RequestBody InputData payment) {
		ChequeTablePerClass cheque = new ChequeTablePerClass();
		cheque.setId(repository.findMaxCheque() + 1);
		cheque.setAmount(payment.getAmount());
		cheque.setChequeNumber(payment.getNumber());
		repository.save(cheque);
		return repository.selectCheque();
	}
}
