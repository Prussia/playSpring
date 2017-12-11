package com.prussia.test.play.spring.service;

import java.util.Map;

public interface KafkaService {

	public void sendToKafka(final String key, final Map<String, Object> data);
}
