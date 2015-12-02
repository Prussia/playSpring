package com.prussia.test.play.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.prussia.test.play.spring.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Iterable<Customer> findByLastName(String lastName);
}
