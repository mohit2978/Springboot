package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.DELETE };
		
		config.getExposureConfiguration()
			  .forDomainType(Book.class)
			  .withItemExposure((metadata, http) -> http.disable(unsupportedMethods))
			  .withCollectionExposure((metadata,http) -> http.disable(unsupportedMethods));
		
	}
}
