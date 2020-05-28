package com.spring.boot.jpa.transaction;

import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
