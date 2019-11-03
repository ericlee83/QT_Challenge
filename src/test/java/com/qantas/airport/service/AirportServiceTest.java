package com.qantas.airport.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qantas.airport.domain.client.Airport;
import com.qantas.airport.domain.client.AirportInfoResponse;
import com.qantas.airport.filter.AirportFilter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportServiceTest {

	@Autowired
	AirportService airportService;

	@Test
	public void testFindMelbourneAirportsByFilter() {
		AirportFilter filter = new AirportFilter.AirportFilterBuilder().hasAirportCode("MEL").build();
		AirportInfoResponse melbourneAirportInfo = airportService.findAirports(filter);
		Assertions.assertThat(melbourneAirportInfo.getAirports()).extracting(Airport::getCode).containsOnly("MEL");
	}

	@Test
	public void testFindAustriliaAirportsByFilter() {
		AirportFilter filter = new AirportFilter.AirportFilterBuilder().fromCountryCode("AU").build();
		AirportInfoResponse melbourneAirportInfo = airportService.findAirports(filter);
		Assertions.assertThat(melbourneAirportInfo.getAirports()).extracting(airport -> airport.getCountry().getCode())
				.containsOnly("AU");
	}

	@Test
	public void testFindInternationalAirportsByFilter() {
		AirportFilter filter = new AirportFilter.AirportFilterBuilder().isInternationalAirport("true").build();
		AirportInfoResponse melbourneAirportInfo = airportService.findAirports(filter);
		Assertions.assertThat(melbourneAirportInfo.getAirports())
				.extracting(airport -> airport.getInternationalAirport()).containsOnly(true);
	}

	@Test
	public void testFindRegionalAirportsByFilter() {
		AirportFilter filter = new AirportFilter.AirportFilterBuilder().isRegionalAirport("true").build();
		AirportInfoResponse melbourneAirportInfo = airportService.findAirports(filter);
		Assertions.assertThat(melbourneAirportInfo.getAirports()).extracting(airport -> airport.getRegionalAirport())
				.containsOnly(true);
	}

}
