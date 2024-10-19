package com.demo.mohit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String publishMsg1(Order order) {

		// publish msg to kafka topic
		kafkaTemplate.send(AppConstants.TOPIC, order);

		return "Msg Published To Kafka Topic";
	}

	
}
