package com.qantas.airport.filter;

import java.util.ArrayList;
import java.util.List;

import com.qantas.airport.filter.strategy.AirportCodeFilterStrategy;
import com.qantas.airport.filter.strategy.AirportCountryCodeFilterStrategy;
import com.qantas.airport.filter.strategy.AirportInternationalFilterStrategy;
import com.qantas.airport.filter.strategy.AirportRegionalFilterStrategy;
import com.qantas.airport.filter.strategy.FilterStrategy;

public class AirportFilter {

	List<FilterStrategy> strategies;

	public void addStrategy(FilterStrategy strategy) {
		this.strategies.add(strategy);
	}

	public List<FilterStrategy> getStrategies() {
		return this.strategies;
	}

	private AirportFilter() {
		super();
		strategies = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public static class AirportFilterBuilder {
		private String countryCode;
		private String airportCode;
		private String internationalAirport;
		private String regionalAirport;

		public AirportFilterBuilder() {

		}

		public AirportFilterBuilder fromCountryCode(String countryCode) {
			this.countryCode = countryCode;
			return this;
		}

		public AirportFilterBuilder hasAirportCode(String airportCode) {
			this.airportCode = airportCode;
			return this;
		}

		public AirportFilterBuilder isInternationalAirport(String internationalAirport) {
			this.internationalAirport = internationalAirport;
			return this;
		}

		public AirportFilterBuilder isRegionalAirport(String regionalAirport) {
			this.regionalAirport = regionalAirport;
			return this;
		}

		public AirportFilter build() {
			AirportFilter filter = new AirportFilter();
			filter.addStrategy(new AirportCountryCodeFilterStrategy(this.countryCode));
			filter.addStrategy(new AirportCodeFilterStrategy(this.airportCode));
			filter.addStrategy(new AirportInternationalFilterStrategy(this.internationalAirport));
			filter.addStrategy(new AirportRegionalFilterStrategy(regionalAirport));
			return filter;
		}
	}
}
