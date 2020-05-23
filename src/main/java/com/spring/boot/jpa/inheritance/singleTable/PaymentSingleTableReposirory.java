package com.spring.boot.jpa.inheritance.singleTable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentSingleTableReposirory extends CrudRepository<PaymentSingleTable, Integer> {
	@Query(value = "select COALESCE(max(id), 0) maxId from PAYMENT_SINGLE_TABLE", nativeQuery = true)
	int findMaxId();
}
