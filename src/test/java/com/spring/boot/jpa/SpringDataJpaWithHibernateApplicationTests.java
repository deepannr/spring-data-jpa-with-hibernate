package com.spring.boot.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.jpa.product.data.Product;
import com.spring.boot.jpa.product.repo.ProductRepository;

@SpringBootTest
class SpringDataJpaWithHibernateApplicationTests {
	
	private ProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Product product = new Product("M30", "Samsung", 13000d);
		repository.save(product);
	}
}
