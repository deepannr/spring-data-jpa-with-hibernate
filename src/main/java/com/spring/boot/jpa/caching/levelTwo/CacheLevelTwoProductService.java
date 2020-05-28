package com.spring.boot.jpa.caching.levelTwo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.boot.jpa.exception.ResourceNotFoundException;

@Service
class CacheLevelTwoProductService {
	@Autowired
	private CacheLevelTwoProductRepository repository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public CacheLevelTwoProduct getProductById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Optional<CacheLevelTwoProduct> optionalProduct = repository.findById(id);
		
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product Id: " + id + " not Found");
		}
		CacheLevelTwoProduct product = optionalProduct.get();
		session.evict(product);
		System.out.println("Evict");
		repository.findById(id);
		return product;
	}
}
