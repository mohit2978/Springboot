package com.mohit.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="015-rest-api-microservice")
public interface WelcomeClient {
	
	@GetMapping("/welcome")
	public String invokeWelcomeApi();
}
