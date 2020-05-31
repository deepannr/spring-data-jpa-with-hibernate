package com.spring.boot.jpa.miniProj.data;

public class InputPatient {
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private String providerName;
	
	private String copay;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getCopay() {
		return copay;
	}

	public void setCopay(String copay) {
		this.copay = copay;
	}
}
