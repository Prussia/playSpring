package com.prussia.test.play.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prussia.test.play.spring.domain.po.Customer;

@Repository
public interface CustomerRepostory extends CrudRepository<Customer, Long> {

}
