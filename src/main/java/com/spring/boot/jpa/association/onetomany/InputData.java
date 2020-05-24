package com.spring.boot.jpa.association.onetomany;

import java.util.Set;

class InputData {
	private String name;
	
	private Set<OMPhoneNumber> numbers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OMPhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<OMPhoneNumber> numbers) {
		this.numbers = numbers;
	}
}
