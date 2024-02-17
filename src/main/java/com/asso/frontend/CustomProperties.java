package com.asso.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix = "com.asso.frontend")
@Data
public class CustomProperties {
	private String apiUrl;

	public synchronized String getApiUrl() {
		return apiUrl;
	}

	public synchronized void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	
	

}
