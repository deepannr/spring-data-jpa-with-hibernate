package com.spring.boot.jpa.inheritance.tablePerClass;

import javax.persistence.Entity;

@Entity
public class ChequeTablePerClass extends PaymentTablePerClass {
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
}
