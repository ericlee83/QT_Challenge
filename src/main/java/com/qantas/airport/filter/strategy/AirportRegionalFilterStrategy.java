package com.qantas.airport.filter.strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.qantas.airport.domain.client.Airport;


public class AirportRegionalFilterStrategy implements FilterStrategy {
	
	private String regionalAirport;
	
	public String getRegionalAirport(){
		return regionalAirport;
	}

	public AirportRegionalFilterStrategy(String regionalAirport) {
		super();
		this.regionalAirport = regionalAirport;
	}


	@Override
	public List<Airport> filterAirports(List<Airport> airports) {
		if(StringUtils.isNotBlank(regionalAirport)) {
			boolean isRegionalAirport = Boolean.TRUE.toString().equalsIgnoreCase(regionalAirport);
			airports = airports.stream().filter(airport->isRegionalAirport== airport.getRegionalAirport()).collect(Collectors.toList());
		}
		return airports;
	}
	
	

}
