package com.spring.boot.jpa.compositeKey.idClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdClassCustomerRepository extends JpaRepository<IdClassCustomer, CustomerIdClass> {

}
