package com.prussia.test.play.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String data) throws Exception {
		Thread.sleep(1000*5);
		log.warn("uppercase messages......");
		return data.toUpperCase();
	}

}
