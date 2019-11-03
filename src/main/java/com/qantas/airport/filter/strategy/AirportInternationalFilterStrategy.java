package com.qantas.airport.filter.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.qantas.airport.domain.client.Airport;


public class AirportInternationalFilterStrategy implements FilterStrategy {
	
	private String internationalAirport;
	
	public String getInternationalAirport(){
		return internationalAirport;
	}

	public AirportInternationalFilterStrategy(String internationalAirport) {
		super();
		this.internationalAirport = internationalAirport;
	}

	@Override
	public List<Airport> filterAirports(List<Airport> airports) {
		if(StringUtils.isNotBlank(internationalAirport)) {
			boolean isInternationalAirport = Boolean.TRUE.toString().equalsIgnoreCase(internationalAirport);
			airports = airports.stream().filter(airport->isInternationalAirport== airport.getInternationalAirport()).collect(Collectors.toList());
		}
		return airports;
	}

}
