
package com.qantas.airport.domain.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Location Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude"
})
public class Location {

    /**
     * The Latitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    private Double latitude = 0.0D;
    /**
     * The Longitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    private Double longitude = 0.0D;

    /**
     * The Latitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    /**
     * The Latitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * The Longitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    /**
     * The Longitude Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

}
