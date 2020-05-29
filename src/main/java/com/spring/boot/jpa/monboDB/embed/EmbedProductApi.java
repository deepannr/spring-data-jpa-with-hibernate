package com.spring.boot.jpa.monboDB.embed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo/emded")
class EmbedProductApi {
	
	@Autowired
	private EmbedProductRepository repository;
	
	@PostMapping("/save")
	public void save(@RequestBody InputData input) {
		EmbedProduct product = new EmbedProduct();
		product.setName(input.getName());
		product.setPrice(input.getPrice());
		
		repository.save(product);
	}

}
