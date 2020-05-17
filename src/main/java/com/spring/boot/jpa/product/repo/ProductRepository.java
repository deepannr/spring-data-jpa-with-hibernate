package com.spring.boot.jpa.product.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.jpa.product.data.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
