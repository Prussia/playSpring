package com.prussia.test.play.spring.repository;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.prussia.test.play.spring.domain.Customer;

@Component
@CacheConfig(cacheNames = "Customers")
public class CachableCustomerRepository {

	@Cacheable
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public Customer findByLastName(String lastName) {
		System.out.println("---> Loading Customer with last name '" + lastName + "'"); //when the value can be found in cache, the method won't be invoked
		return new Customer(1, "firstName", lastName);
	}
	
	/**
	 * http://tianmaying.com/tutorial/spring-web-ehcache#15
	 */
}
