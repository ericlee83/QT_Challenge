package com.qantas.airport.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qantas.airport.domain.client.AirportInfoResponse;
import com.qantas.airport.filter.AirportFilter;
import com.qantas.airport.service.AirportService;


@RestController
@Validated
public class AirportRestController {

	@Autowired
	private AirportService airportDelegator;
	
	@GetMapping(value = "/rest/airports")
	public AirportInfoResponse findAirports(){
		return airportDelegator.findAirports();
	}
	
	@GetMapping(value = "/rest/airports/filters")
	public AirportInfoResponse findAirportsByQuery(
			@RequestParam(value="countryCode", required=false) @Length(min = 2, max = 2) String countryCode,
			@RequestParam(value="airportCode", required=false) @Length(min = 3, max = 3) String airportCode,
			@RequestParam(value="internationalAirport", required=false) @Length(min = 4, max = 5, message = "The value of internationalAirport must be true or false") String internationalAirport,
			@RequestParam(value="regionalAirport", required=false) @Length(min = 4, max = 5, message = "The value of regionalAirport must be true or false") String regionalAirport){
		AirportFilter filter = new AirportFilter.AirportFilterBuilder()
				.hasAirportCode(airportCode)
				.fromCountryCode(countryCode)
				.isInternationalAirport(internationalAirport)
				.isRegionalAirport(regionalAirport)
				.build();
		return airportDelegator.findAirports(filter);
	}
}
