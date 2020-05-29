package com.spring.boot.jpa.compositeKey.embed;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
class EmbedCustomer {

	@EmbeddedId
	private EmbedCustomerId customer;
	
	private String name;

	public EmbedCustomerId getCustomer() {
		return customer;
	}

	public void setCustomer(EmbedCustomerId customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
