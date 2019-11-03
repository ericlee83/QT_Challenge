package com.qantas.airport;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qantas.airport.controller.AirportRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirportFinderApplicationTests {

	@Autowired
	AirportRestController flightRestController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(flightRestController).isNotNull();
	}

}
