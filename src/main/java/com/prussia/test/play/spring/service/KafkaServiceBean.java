package com.prussia.test.play.spring.service;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaServiceBean implements KafkaService {

	@Autowired
	private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;

	public void sendToKafka(final String key, final Map<String, Object> data) {
		final ProducerRecord<String, Map<String, Object>> record = createRecord("producer_count_topic", key, data);

		ListenableFuture<SendResult<String, Map<String, Object>>> future = kafkaTemplate.send(record);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Map<String, Object>>>() {

			@Override
			public void onSuccess(SendResult<String, Map<String, Object>> result) {
				log.info("result = {}", result.getRecordMetadata());

			}

			@Override
			public void onFailure(Throwable ex) {
				// handleFailure(data, record, ex);
			}

		});
	}

	private ProducerRecord<String, Map<String, Object>> createRecord(String topic, String key,
			Map<String, Object> data) {
		ProducerRecord<String, Map<String, Object>> record = new ProducerRecord<String, Map<String, Object>>(topic, key,
				data);

		return record;
	}
}
