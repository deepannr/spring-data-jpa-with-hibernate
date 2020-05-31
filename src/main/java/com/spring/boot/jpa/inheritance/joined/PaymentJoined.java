package com.spring.boot.jpa.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel("All Details about Payments")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "joined_payment")
public abstract class PaymentJoined {
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
