package com.spring.boot.jpa.compositeKey.embed;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
class EmbedCustomerId implements Serializable {

	private static final long serialVersionUID = 2222L;

	private int id;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}