package com.spring.boot.jpa.product.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.exception.ResourceNotFoundException;
import com.spring.boot.jpa.product.data.Product;
import com.spring.boot.jpa.product.repo.ProductRepository;

@RestController
@RequestMapping ("/product")
public class ProductApi {
	
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/create")
	public void create(@Valid @RequestBody Product product) {
		repository.save(product);
	}
	
	@GetMapping("/all")
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Product> getById(@PathVariable int id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product Id: " + id + " not Found");
		}
		return repository.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		Optional<Product> optionalProduct = getById(id);
		
		Product updateProduct = optionalProduct.get();
		updateProduct.setName(product.getName());
		updateProduct.setDesc(product.getDesc());
		updateProduct.setPrice(product.getPrice());
		repository.save(updateProduct);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeProduct(@PathVariable int id) {
		getById(id);
		repository.deleteById(id);
	}
}
