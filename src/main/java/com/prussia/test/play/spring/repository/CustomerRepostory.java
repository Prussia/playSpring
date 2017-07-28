package com.prussia.test.play.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prussia.test.play.spring.domain.po.Customer;


public interface CustomerRepostory extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByFirstName(String firstName);

}
