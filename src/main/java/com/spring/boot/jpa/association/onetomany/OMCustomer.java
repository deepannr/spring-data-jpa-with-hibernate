package com.spring.boot.jpa.association.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OMCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	/**
	 * mappedBy = This owns tells who owns the mapping. 
	 * 
	 * If Cascade is not provided then no entries in phone number table. 
	 * 
	 * If FetchType.LAZY then fetching
	 * following code loads the Phone number on demand which improves performance.
	 * If getting LazyInitializationException then add @Transactional annotation.
	 */
	@OneToMany(mappedBy = "omCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OMPhoneNumber> numbers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<OMPhoneNumber> getNumbers() {
		return numbers;
	}

	/**
	 * If addPhoneNumber is not provided then customer_id foreign key will be null
	 * and no mapping present between tables. Except customer_id field values will
	 * have values.
	 */
	public void addPhoneNumber(OMPhoneNumber phone) {
		if(phone != null) {
			if (numbers == null) {
				numbers = new HashSet<>();
			}
			phone.setOmCustomer(this);
			numbers.add(phone);
		}
	}
}
