package com.qantas.airport.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qantas.airport.domain.client.AirportInfoResponse;

@Component
public class RestClientUtil {
	
	@Value( "${rest.header.accept}" )
	private  String acceptType;
	
	@Value( "${rest.endpoint}" )
	private  String endPointUrl;

	public HttpEntity<String> getHttpEntitys(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", acceptType);
        HttpEntity<String> entities = new HttpEntity<String>(headers);
        return entities;
	 }

	public AirportInfoResponse getAirportInfoResponse(){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(endPointUrl, HttpMethod.GET, getHttpEntitys(), AirportInfoResponse.class).getBody();
	}

}
