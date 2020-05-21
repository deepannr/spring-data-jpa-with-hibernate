package com.spring.boot.jpa.basic;

import java.util.List;
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

@RestController
@RequestMapping ("/product")
public class ProductApi {
	
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/create")
	public void create(@Valid @RequestBody ProductBasic product) {
		repository.save(product);
	}
	
	@GetMapping("/all")
	public Iterable<ProductBasic> getAllProducts() {
		return repository.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<ProductBasic> getById(@PathVariable int id) {
		Optional<ProductBasic> optionalProduct = repository.findById(id);
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product Id: " + id + " not Found");
		}
		return repository.findById(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateProduct(@PathVariable int id, @RequestBody ProductBasic product) {
		Optional<ProductBasic> optionalProduct = getById(id);
		
		ProductBasic updateProduct = optionalProduct.get();
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
	
	/**
	 * Search Operations
	 */
	
	@GetMapping("/findByName/{name}")
	public List<ProductBasic> findByName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@GetMapping("/findByNameAndDesc/{name}/{desc}")
	public List<ProductBasic> findByNameAndDesc(@PathVariable String name, @PathVariable String desc) {
		return repository.findByNameAndDesc(name, desc);
	}
	
	@GetMapping("/findByPrice/{price}")
	List<ProductBasic> findByPriceGreaterThanEqual(@PathVariable double price) {
		return repository.findByPriceGreaterThanEqual(price);
	}
	
	@GetMapping("/findByNameContains/{name}")
	List<ProductBasic> findByNameContains(@PathVariable String name) {
		return repository.findByNameContains(name);
	}
	
	@GetMapping("/findByPriceBetween/{from}/{to}")
	List<ProductBasic> findByPriceBetween(@PathVariable double from, @PathVariable double to) {
		return repository.findByPriceBetween(from, to);
	}
	
	@GetMapping("/findByNameLike/{name}")
	List<ProductBasic> findByNameLike(@PathVariable String name) {
		return repository.findByNameLike("%" + name + "%");
	}
	
	@GetMapping("/findByIdIn/{ids}")
	List<ProductBasic> findByIdIn(@PathVariable List<Integer> ids) {
		return repository.findByIdIn(ids);
	}
}
