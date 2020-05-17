package com.spring.boot.jpa.product.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.jpa.product.data.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name, String desc);
	
	List<Product> findByPriceGreaterThanEqual(double price);
	
	// Like Search ('%ov%')
	List<Product> findByNameContains(String name);
	
	// Between Search
	List<Product> findByPriceBetween(double from, double to);
	
	// Like Search
	List<Product> findByNameLike(String name);
	
	// In search
	List<Product> findByIdIn(List<Integer> ids);
}
