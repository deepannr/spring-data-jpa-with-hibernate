package com.spring.boot.jpa.association.caching.levelTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/cache/levelTwo/product")
public class CacheLevelTwoProductApi {
	
	@Autowired
	private CacheLevelTwoProductService service;
	
	@GetMapping("/find/{id}")
	public CacheLevelTwoProduct getById(@PathVariable int id) {
		return service.getProductById(id);
	}
}