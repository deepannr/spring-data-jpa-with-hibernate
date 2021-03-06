package com.spring.boot.jpa.compositeKey.idClass;

import java.io.Serializable;

class CustomerIdClass implements Serializable {

	private static final long serialVersionUID = 1111L;

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
