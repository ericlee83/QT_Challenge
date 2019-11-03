package com.qantas.airport.filter.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.qantas.airport.domain.client.Airport;


public class AirportCountryCodeFilterStrategy implements FilterStrategy{
	
	private String countryCode;
	
	public String getCountryCode(){
		return countryCode;
	}

	public AirportCountryCodeFilterStrategy(String countryCode) {
		super();
		this.countryCode = countryCode;
	}



	@Override
	public List<Airport> filterAirports(List<Airport> airports) {
		if(StringUtils.isNoneBlank(countryCode)) {
			airports = airports.stream().filter(airport->countryCode.equalsIgnoreCase(airport.getCountry().getCode()))
					.collect(Collectors.toList());
		}
		return airports;
	}

}
