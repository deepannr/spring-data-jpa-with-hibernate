package com.spring.boot.jpa.saveAndRetrieveFiles;

import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {

}
