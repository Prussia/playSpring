package com.prussia.test.play.spring.batch;

import org.springframework.batch.item.ItemReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Reader implements ItemReader<String> {

	private String[] messages = { "javainuse.com", "Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;

	@Override
	public String read() throws Exception{

		if (count < messages.length) {
			return messages[count++];
		} else {
			count = 0;
		}
		return null;
	}

}