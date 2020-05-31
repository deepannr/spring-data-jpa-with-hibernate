package com.spring.boot.jpa.inheritance.joined;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJoinedRepository extends CrudRepository<PaymentJoined, Integer> {
	@Query(value = "select COALESCE(max(id), 0) maxId from JOINED_PAYMENT", nativeQuery = true)
	int findMaxId();
	
	@Query("FROM CreditCardJoined")
	List<PaymentJoined> selectCreditCard();
	
	@Query("FROM ChequeJoined")
	List<PaymentJoined> selectCheque();
}
