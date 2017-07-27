package com.prussia.test.myspring.entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.prussia.test.play.spring.Application;
import com.prussia.test.play.spring.domain.po.Customer;
import com.prussia.test.play.spring.repository.CustomerRepostory;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Slf4j
public class OneToOneTests {
	@Autowired
	private CustomerRepostory customerRepo;
	private Customer expectCustomer;

	@Before
	public void init() {
		expectCustomer = new Customer();
		expectCustomer.setFirstName("Jimmy");
		expectCustomer.setLastName("Jin");
	}

	@Test
	public void testInsertCustomer() {
		customerRepo.saveAndFlush(expectCustomer);
	}

	@Test
	public void testFindOne() {
		Customer customer = customerRepo.getOne(1L);

		Assert.assertTrue(expectCustomer.getFirstName().equals(customer.getFirstName()));
		Assert.assertTrue(expectCustomer.getLastName().equals(customer.getLastName()));
	}
	
	@Test
	public void testFindCustomer() {
		List<Customer> customers = customerRepo.findByFirstName("Jimmy");
		Assert.assertEquals(1, customers.size());

	}
}
