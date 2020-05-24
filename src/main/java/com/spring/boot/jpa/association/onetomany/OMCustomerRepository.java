package com.spring.boot.jpa.association.onetomany;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OMCustomerRepository extends CrudRepository<OMCustomer, Integer> {
	@Query(value = "Select cust.id, cust.name, phone.number, phone.type from OMCUSTOMER cust, OMPHONE_NUMBER phone where cust.id = phone.customer_id", nativeQuery = true)
	List<Object[]> findAllCustomer();
}
