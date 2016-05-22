package com.prussia.test.play.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prussia.test.play.spring.dao.CachableCustomerDao;
import com.prussia.test.play.spring.dao.CustomerDao;
import com.prussia.test.play.spring.domain.po.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	
	@Autowired
	//@Qualifier ( "customerDao" ) //inject by specific name
	CustomerDao repository;
	
	@Autowired
	CachableCustomerDao cachableRepository;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String get(Long id) {
		log.info("method = get");
		log.info("run cachable method : " + cachableRepository.findByLastName("Bloch"));;
		log.info("customerDao" + repository.toString());
		if (id == null) {
			Iterable<Customer> customers = repository.findAll();
			customers.forEach(customer -> log.info(customer.toString()));
			return customers.toString();
		} else {
			Customer customer = repository.findOne(id);
			log.info(customer.toString());
			return customer.toString();
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody long create(@RequestBody Customer customer) {
		Customer customerVo = repository.save(customer);
		return customerVo.getId();
	}
}
