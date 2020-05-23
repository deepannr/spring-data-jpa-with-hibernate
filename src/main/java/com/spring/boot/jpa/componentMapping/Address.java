package com.spring.boot.jpa.componentMapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class Address {
	@Column(name = "street")
	private String streetAddress;
	
	private String city;
	
	@Column(name = "zip")
	private int zipCode;
	
	private String state;
	
	private String country;

	public Address() {
		super();
	}

	public Address(String streetAddress, String city, int zipCode, String state, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
