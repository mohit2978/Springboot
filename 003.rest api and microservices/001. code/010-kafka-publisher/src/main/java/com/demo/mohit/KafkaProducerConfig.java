package com.demo.mohit;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.JsonSerializer;




@Configuration
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String, Order> producerFactory(){
		
		Map<String, Object> configprops = new HashMap<>();
		
		configprops.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
		configprops.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configprops.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		
		return new DefaultKafkaProducerFactory<>(configprops);
		
	}
	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate(){
		return  new KafkaTemplate<>(producerFactory());
	}
	
}
