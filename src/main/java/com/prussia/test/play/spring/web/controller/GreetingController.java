package com.prussia.test.play.spring.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prussia.test.play.spring.domain.po.Greeting;
@Scope("request") // the default controller scope is singleton. so set it to prototype, request or session
@RestController
public class GreetingController {
	
	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	private static final String template = "Hello,%s!";
	private final AtomicLong counter = new AtomicLong();
	private long longNumber = 0l;
	
	/**
	 * Use two different explorer to check the concurrent issue in singleton mode
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "world") String name) throws Exception{
		log.info("Thread name = {}", Thread.currentThread().getName());
		log.info("longNumber = {}", longNumber);
		++longNumber;
		log.info("begin sleep");
		Thread.sleep(10000);
		log.info("longNumber = {}", longNumber);
		
		log.info("this = {}", this.toString());
		return new Greeting(longNumber, String.format(template, name));
		
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
