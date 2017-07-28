package com.prussia.test.myspring.entity;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
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
//@Transactional
public class OneToOneTests {
	@Autowired
	private CustomerRepostory customerRepo;
	private Customer expectCustomer;
	private BeanUtilsBean beanUtil;

	@Before
	public void init() {
		beanUtil = new BeanUtilsBean();
		expectCustomer = new Customer();
		expectCustomer.setId(1L);
		expectCustomer.setFirstName("Jimmy");
		expectCustomer.setLastName("Jin");
		expectCustomer.setCreatedDate(new Date());
		expectCustomer.setUpdatedDate(new Date());
	}

	@Test
	public void testInsertCustomer() throws Exception {
		Customer customer = customerRepo.saveAndFlush(expectCustomer);
		beanUtil.copyProperties(expectCustomer, customer);
		Assert.assertNotNull(expectCustomer);
		Assert.assertNotNull(expectCustomer.getId());
		Assert.assertNotNull(expectCustomer.getFirstName().equals("Jimmy"));
		Assert.assertNotNull(expectCustomer.getLastName().equals("Jin"));
	}

	@Test
	public void testFindOne() {
		Customer customer = customerRepo.getOne(expectCustomer.getId());
		
		
		Assert.assertTrue(expectCustomer.getFirstName().equals(customer.getFirstName()));
		Assert.assertTrue(expectCustomer.getLastName().equals(customer.getLastName()));
	}
	
	@Test
	public void testFindCustomer() {
		List<Customer> customers = customerRepo.findAll();
		Assert.assertEquals(1, customers.size());
		Assert.assertEquals(expectCustomer.getFirstName(), customers.get(0).getFirstName());
		Assert.assertEquals(expectCustomer.getLastName(), customers.get(0).getLastName());
		Assert.assertEquals(expectCustomer.getId(), customers.get(0).getId());
		Assert.assertNotNull(customers.get(0).getCreatedDate());
		Assert.assertNotNull(customers.get(0).getUpdatedDate());
	}
}
