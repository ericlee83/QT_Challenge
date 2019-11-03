package com.qantas.airport.filter.strategy;

import java.util.List;

import com.qantas.airport.domain.client.Airport;

public interface FilterStrategy {
	public List<Airport> filterAirports(List<Airport> airports);
}
