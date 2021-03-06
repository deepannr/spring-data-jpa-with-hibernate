package com.spring.boot.jpa.inheritance.tablePerClass;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTablePerClassRepository extends CrudRepository<PaymentTablePerClass, Integer> {
	@Query(value = "select COALESCE(max(id), 0) maxId from TABLE_PER_CLASS_CREDIT_CARD", nativeQuery = true)
	int findMaxCreditCard();
	
	@Query("from CreditCardTablePerClass")
	List<PaymentTablePerClass> selectCreditCard();
	
	@Query(value = "select COALESCE(max(id), 0) maxId from TABLE_PER_CLASS_CHEQUE", nativeQuery = true)
	int findMaxCheque();
	
	@Query("from ChequeTablePerClass")
	List<PaymentTablePerClass> selectCheque();
}
