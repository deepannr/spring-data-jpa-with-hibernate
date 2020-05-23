package com.spring.boot.jpa.inheritance.singleTable;

class InputData {
	private int amount;
	
	private String number;

	public InputData() {
		super();
	}
	
	public InputData(int amount, String number) {
		this.amount = amount;
		this.number = number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
