package com.prussia.test.play.spring.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Writer implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> messages) throws Exception {
		log.debug("start sleeping 5s");
		Thread.sleep(1000*15);
		log.warn("writing messages......");
		for (String msg : messages) {
			Thread.sleep(1000*15);
			System.out.println("Writing the data " + msg);
		}
	}

}
