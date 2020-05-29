package com.spring.boot.jpa.monboDB.embed;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmbedProductRepository extends MongoRepository<EmbedProduct, String> {

}
