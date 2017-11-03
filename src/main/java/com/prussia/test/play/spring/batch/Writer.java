package com.prussia.test.play.spring.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> messages) throws Exception {
		for (String msg : messages) {
			System.out.println("Writing the data " + msg);
		}
	}

}
