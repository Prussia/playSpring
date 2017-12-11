package com.prussia.test.play.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prussia.test.play.spring.service.KafkaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/kafka")
@Slf4j
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;

	@RequestMapping(value = "/producer/count/topic", method = RequestMethod.POST)
	public @ResponseBody String sendProducerCount(@RequestParam("lineno") int lineno, 
			@RequestParam("key") String key) {
		Map<String, Object> map = new HashMap<>();
		map.put("lineno", lineno);
		map.put("key", key);
		kafkaService.sendToKafka("producer_count_topic", key, map);
		return "";
	}
	
	@RequestMapping(value = "/consumer/count/topic", method = RequestMethod.POST)
	public @ResponseBody String sendConsumerCount(@RequestParam("lineno") int lineno, 
			@RequestParam("key") String key) {
		Map<String, Object> map = new HashMap<>();
		map.put("lineno", lineno);
		map.put("key", key);
		kafkaService.sendToKafka("persisted_rdd_topic", key, map);
		return "";
	}
	
	
}
