package com.spring.boot.jpa.pageAndSort;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPagingAndSortingRepository extends PagingAndSortingRepository<ProductPageAndSort, Integer> {
	List<ProductPageAndSort> findByName(String name);
	
	List<ProductPageAndSort> findByNameAndDesc(String name, String desc);
	
	List<ProductPageAndSort> findByPriceGreaterThanEqual(double price);
	
	// Like Search ('%ov%')
	List<ProductPageAndSort> findByNameContains(String name);
	
	// Between Search
	List<ProductPageAndSort> findByPriceBetween(double from, double to);
	
	// Like Search
	List<ProductPageAndSort> findByNameLike(String name);
	
	// In search
	List<ProductPageAndSort> findByIdIn(List<Integer> ids);
}
