package com.qantas.airport.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qantas.airport.domain.client.AirportInfoResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntergrationTest {
	
	@Autowired
	AirportRestController airportRestController;
	
	@Test
	public void testFindAirports(){
		AirportInfoResponse airportInfo = airportRestController.findAirports();
		Assertions.assertThat(airportInfo.getAirports()).isNotEmpty();
	}
	
	@Test
	public void testFindAustraliaInternationalAirport(){
		AirportInfoResponse austriliaInternationalAirportInfo = airportRestController.findAirportsByQuery("AU", null, "true", null);
		
		Assertions.assertThat(austriliaInternationalAirportInfo.getAirports())
		.extracting(airport->airport.getInternationalAirport()).containsOnly(true);
		
		Assertions.assertThat(austriliaInternationalAirportInfo.getAirports())
		.extracting(airport->airport.getCountry().getCode()).containsOnly("AU");
	}
	
	@Test
	public void testFindAustraliaRegionalAirport(){
		AirportInfoResponse australiaRegionalAirportInfo = airportRestController.findAirportsByQuery("AU", null, null, "true");
		
		Assertions.assertThat(australiaRegionalAirportInfo.getAirports())
		.extracting(airport->airport.getRegionalAirport()).containsOnly(true);
		
		Assertions.assertThat(australiaRegionalAirportInfo.getAirports())
		.extracting(airport->airport.getCountry().getCode()).containsOnly("AU");
	}
	
	@Test
	public void testFindSydneyAirportByAirportCodeSYD(){
		AirportInfoResponse sydneyAirportInfo = airportRestController.findAirportsByQuery(null, "SYD", null, null);
		Assertions.assertThat(sydneyAirportInfo.getAirports())
		.extracting(airport->airport.getCode()).containsOnly("SYD");
	}

}
