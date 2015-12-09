package com.prussia.test.play.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.prussia.test.play.spring.domain.Customer;

@Component
public interface CustomerDao extends CrudRepository<Customer, Long> {

	Iterable<Customer> findByLastName(String lastName);
}
