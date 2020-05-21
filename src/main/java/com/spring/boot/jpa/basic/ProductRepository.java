package com.spring.boot.jpa.basic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductBasic, Integer> {
	List<ProductBasic> findByName(String name);
	
	List<ProductBasic> findByNameAndDesc(String name, String desc);
	
	List<ProductBasic> findByPriceGreaterThanEqual(double price);
	
	// Like Search ('%ov%')
	List<ProductBasic> findByNameContains(String name);
	
	// Between Search
	List<ProductBasic> findByPriceBetween(double from, double to);
	
	// Like Search
	List<ProductBasic> findByNameLike(String name);
	
	// In search
	List<ProductBasic> findByIdIn(List<Integer> ids);
}
