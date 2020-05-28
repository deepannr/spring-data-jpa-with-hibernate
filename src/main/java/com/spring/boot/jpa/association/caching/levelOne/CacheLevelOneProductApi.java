package com.spring.boot.jpa.association.caching.levelOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/cache/levelOne/product")
public class CacheLevelOneProductApi {
	
	@Autowired
	private CacheLevelOneProductService service;
	
	@GetMapping("/find/{id}")
	public CacheLevelOneProduct getById(@PathVariable int id) {
		return service.getProductById(id);
	}
}