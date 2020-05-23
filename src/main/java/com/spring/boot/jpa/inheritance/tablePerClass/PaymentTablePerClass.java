package com.spring.boot.jpa.inheritance.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("All Details about Payments")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PaymentTablePerClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
