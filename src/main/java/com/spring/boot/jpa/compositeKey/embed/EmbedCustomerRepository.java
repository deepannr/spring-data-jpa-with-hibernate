package com.spring.boot.jpa.compositeKey.embed;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbedCustomerRepository extends JpaRepository<EmbedCustomer, EmbedCustomerId> {

}
