package com.spring.boot.jpa.inheritance.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "table_per_class_credit_card")
public class CreditCardTablePerClass extends PaymentTablePerClass {
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}