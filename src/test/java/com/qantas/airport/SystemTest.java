package com.qantas.airport;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import com.qantas.airport.domain.client.AirportInfoResponse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemTest {
	

	@Test
	public void test_FindAirports() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.qantas.airports.v1+json;charset=utf-8");
        HttpEntity<String> entities = new HttpEntity<String>(headers);
        AirportInfoResponse dataSrouceResponse = restTemplate.exchange("http://www.qantas.com.au/api/airports", HttpMethod.GET, entities, AirportInfoResponse.class).getBody();

		String url = "http://localhost:8080/rest/airports";
		HttpHeaders testHeaders = new HttpHeaders();
		testHeaders.set("Accept", "application/json");
		HttpEntity<String> testEntities = new HttpEntity<String>(testHeaders);
        TestRestTemplate restTemplateTest = new TestRestTemplate();
        
        AirportInfoResponse response = restTemplateTest.exchange(url, HttpMethod.GET, testEntities, AirportInfoResponse.class).getBody();
		Assertions.assertThat(response.getAirports()).hasSize(dataSrouceResponse.getAirports().size());

	}

}
