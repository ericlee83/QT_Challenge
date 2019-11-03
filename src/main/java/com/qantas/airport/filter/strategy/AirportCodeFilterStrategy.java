package com.qantas.airport.filter.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.qantas.airport.domain.client.Airport;


public class AirportCodeFilterStrategy implements FilterStrategy {
	
	private String airportCode;
	
	public String getAirportCode(){
		return airportCode;
	}

	public AirportCodeFilterStrategy(String airportCode) {
		super();
		this.airportCode = airportCode;
	}

	@Override
	public List<Airport> filterAirports(List<Airport> airports) {
		if(StringUtils.isNoneBlank(airportCode)) {
			airports = airports.stream().filter(airport->airportCode.equalsIgnoreCase(airport.getCode())).collect(Collectors.toList());
		}
		return airports;
	}

}
