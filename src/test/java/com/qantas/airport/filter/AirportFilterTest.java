package com.qantas.airport.filter;

import static org.junit.Assert.*;
import org.junit.Test;

import com.qantas.airport.filter.strategy.AirportCodeFilterStrategy;
import com.qantas.airport.filter.strategy.AirportCountryCodeFilterStrategy;
import com.qantas.airport.filter.strategy.AirportInternationalFilterStrategy;
import com.qantas.airport.filter.strategy.AirportRegionalFilterStrategy;

public class AirportFilterTest {
	
	@Test
	public void testCreateAirportCodeFilter(){
		AirportFilter filters = new AirportFilter.AirportFilterBuilder()
				.hasAirportCode("SDY").build();
		filters.getStrategies().forEach(filter->{
			if(filter instanceof AirportCodeFilterStrategy){
				assertEquals(((AirportCodeFilterStrategy)filter).getAirportCode(),"SDY");
			}
			
		});
	}
	
	@Test
	public void testCreateAirportCountryCodeFilter(){
		AirportFilter filters = new AirportFilter.AirportFilterBuilder()
				.fromCountryCode("AU").build();
		filters.getStrategies().forEach(filter->{
			if(filter instanceof AirportCountryCodeFilterStrategy){
				assertEquals(((AirportCountryCodeFilterStrategy)filter).getCountryCode(),"AU");
			}
			
		});
	}
	
	@Test
	public void testCreateAirportInternationalFilter(){
		AirportFilter filters = new AirportFilter.AirportFilterBuilder()
				.isInternationalAirport("true").build();
		filters.getStrategies().forEach(filter->{
			if(filter instanceof AirportInternationalFilterStrategy){
				assertEquals(((AirportInternationalFilterStrategy)filter).getInternationalAirport(),"true");
			}
			
		});
	}
	
	@Test
	public void testCreateAirportRegionallFilter(){
		AirportFilter filters = new AirportFilter.AirportFilterBuilder()
				.isRegionalAirport("true").build();
		filters.getStrategies().forEach(filter->{
			if(filter instanceof AirportRegionalFilterStrategy){
				assertEquals(((AirportRegionalFilterStrategy)filter).getRegionalAirport(),"true");
			}
			
		});
	}

}
