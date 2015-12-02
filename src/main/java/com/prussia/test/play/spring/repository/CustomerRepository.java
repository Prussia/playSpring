package com.prussia.test.play.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.prussia.test.play.spring.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
