package com.qantas.airport.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qantas.airport.domain.client.Airport;
import com.qantas.airport.domain.client.AirportInfoResponse;
import com.qantas.airport.filter.AirportFilter;
import com.qantas.airport.service.AirportService;

@RunWith(SpringRunner.class)
@WebMvcTest(AirportRestController.class)
public class AirportRestControllerTest {

	@MockBean
	AirportService airportService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testFindAirportsByQuery() throws Exception {
		AirportInfoResponse mockAirportInfo = new AirportInfoResponse();
		Airport sydneyAirports = new Airport();
		sydneyAirports.setCode("SDY");
		List<Airport> airports = new ArrayList<>();
		airports.add(sydneyAirports);
		mockAirportInfo.setAirports(airports);

		AirportFilter filter = new AirportFilter.AirportFilterBuilder().hasAirportCode("SDY").build();

		Mockito.when(airportService.findAirports(filter)).thenReturn(mockAirportInfo);

		mockMvc.perform(get("/rest/airports/filters?airportCode=SDY")).andExpect(status().isOk());

	}

}
