package com.prussia.test.myspring.entity;

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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
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
		customerRepo.save(expectCustomer);
	}

	@Test
	public void testFindCustomer() {
		Customer customer = customerRepo.findOne(1L);

		Assert.assertEquals(expectCustomer, customer);

	}
}
