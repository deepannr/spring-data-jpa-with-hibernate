package com.spring.boot.jpa.pageAndSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/pagingAndSort/product")
public class ProductPagingAndSortingApi {
	
	@Autowired
	private PagingAndSortingRepository<ProductPageAndSort, Integer> repository;

	@GetMapping("/paging/all")
	public Iterable<ProductPageAndSort> getAllPageProducts() {
		Pageable pageable = PageRequest.of(0, 2); //Initial page and number of items per page
		Page<ProductPageAndSort> pageProduct = repository.findAll(pageable);
		pageProduct.forEach(page -> System.out.println(page.getName()));
		return repository.findAll(pageable);
	}
	
	@GetMapping("/sorting/all")
	public Iterable<ProductPageAndSort> getAllSortProducts() {
		return repository.findAll(Sort.by("name", "desc"));
	}
	
	@GetMapping("/sorting/desc/all")
	public Iterable<ProductPageAndSort> getAllSortDescProducts() {
		return repository.findAll(Sort.by(Direction.DESC, "name", "desc"));
	}
	
	@GetMapping("/sorting/multiple/all")
	public Iterable<ProductPageAndSort> getAllSortMultipleProducts() {
		Sort.Order nameOrder = new Sort.Order(Direction.ASC, "name");
		Sort.Order priceOrder = new Sort.Order(Direction.DESC, "price");
		return repository.findAll(Sort.by(priceOrder, nameOrder));
	}
	
	@GetMapping("/pageAndSort/type1/all")
	public Iterable<ProductPageAndSort> getAllPageAndSort1() {
		Pageable pageable = PageRequest.of(0, 3, Direction.DESC, "price");
		return repository.findAll(pageable);
	}
	
	@GetMapping("/pageAndSort/type2/all")
	public Iterable<ProductPageAndSort> getAllPageAndSort2() {
		Pageable pageable = PageRequest.of(1, 4, Sort.by(Direction.DESC, "name", "desc"));
		return repository.findAll(pageable);
	}	
}
