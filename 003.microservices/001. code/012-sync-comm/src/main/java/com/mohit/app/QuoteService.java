package com.mohit.app;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteService {
	
	private static final String QUOTE_ENDPOINT  = "https://jsonplaceholder.typicode.com/users";
	
	public void getQuoteV2() {
		
		WebClient client = WebClient.create();
		
		 System.out.println("Rest api call started...");
		 	
			client.get()
				  .uri(QUOTE_ENDPOINT)
				  .header("Accept", "application/json")
				  .retrieve()
				  .bodyToMono(String.class)
				  .subscribe(QuoteService::handleResponse);
			
		  System.out.println("Rest api call completed...");
	}
	
	public static void handleResponse(String s) {
		System.out.println(s);
		// logic
	}
	
	public void getQuoteV1() {
		
		WebClient client = WebClient.create();
		
		 System.out.println("Rest api call started...");
		 	
		  Mono<String> bodyToMono = client.get()
										  .uri(QUOTE_ENDPOINT)
										  .retrieve()
										  .bodyToMono(String.class);
		  
		  System.out.println(bodyToMono.block());
		  
		  System.out.println("Rest api call completed...");
	}

}