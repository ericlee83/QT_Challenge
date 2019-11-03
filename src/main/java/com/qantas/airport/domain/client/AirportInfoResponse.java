
package com.qantas.airport.domain.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qantas.airport.filter.strategy.FilterStrategy;


/**
 * The Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "airports"
})
public class AirportInfoResponse {

    /**
     * The Airports Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("airports")
    private List<Airport> airports = null;

    /**
     * The Airports Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("airports")
    public List<Airport> getAirports() {
        return airports;
    }

    /**
     * The Airports Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("airports")
    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

	public AirportInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore
	public List<Airport> filterAirports(List<FilterStrategy> strategies){
		strategies.stream().forEach(strategy->this.airports = strategy.filterAirports(this.airports));
		return this.airports;
	}

}
