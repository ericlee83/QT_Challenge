package com.qantas.airport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qantas.airport.domain.client.AirportInfoResponse;
import com.qantas.airport.filter.AirportFilter;
import com.qantas.airport.util.RestClientUtil;

@Component("airportService")
public class AirportService {

	@Autowired
	RestClientUtil restClientUtil;

	public AirportInfoResponse findAirports() {
		return restClientUtil.getAirportInfoResponse();
	}

	public AirportInfoResponse findAirports(final AirportFilter filter) {
		AirportInfoResponse airportInfo = restClientUtil.getAirportInfoResponse();
		airportInfo.filterAirports(filter.getStrategies());
		return airportInfo;
	}
}
