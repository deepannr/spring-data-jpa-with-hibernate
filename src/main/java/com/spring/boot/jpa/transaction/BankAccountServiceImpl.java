package com.spring.boot.jpa.transaction;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.exception.InvalidInputException;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountRepository repository;
	
	@Override
	@Transactional
	public void transfer(int amount) {
		int tempVal = 10;
		
		Optional<BankAccount> deeOptionalAccount = repository.findById(1);
		BankAccount deeAccount  = deeOptionalAccount.get();
		deeAccount.setBalance(deeAccount.getBalance() - amount);
		repository.save(deeAccount);
		++tempVal;

		if(tempVal > 10) {
			throw new InvalidInputException("Test For Exception");
		}
		
		Optional<BankAccount> subOptionalAccount = repository.findById(2);
		BankAccount subAccount  = subOptionalAccount.get();
		subAccount.setBalance(subAccount.getBalance() + amount);
		repository.save(subAccount);
	}

}
