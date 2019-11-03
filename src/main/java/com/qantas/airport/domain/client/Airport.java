
package com.qantas.airport.domain.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Items Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code", "display_name", "international_airport", "regional_airport", "location", "currency_code",
		"timezone", "country" })
public class Airport {

	/**
	 * The Code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("code")
	private String code = "";
	/**
	 * The Display_name Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("display_name")
	private String displayName = "";
	/**
	 * The International_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("international_airport")
	private Boolean internationalAirport = false;
	/**
	 * The Regional_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("regional_airport")
	private Boolean regionalAirport = false;
	/**
	 * The Location Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("location")
	private Location location;
	/**
	 * The Currency_code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currency_code")
	private String currencyCode = "";
	/**
	 * The Timezone Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("timezone")
	private String timezone = "";
	/**
	 * The Country Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("country")
	private Country country;

	/**
	 * The Code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	/**
	 * The Code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * The Display_name Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("display_name")
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * The Display_name Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("display_name")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * The International_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("international_airport")
	public Boolean getInternationalAirport() {
		return internationalAirport;
	}

	/**
	 * The International_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("international_airport")
	public void setInternationalAirport(Boolean internationalAirport) {
		this.internationalAirport = internationalAirport;
	}

	/**
	 * The Regional_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("regional_airport")
	public Boolean getRegionalAirport() {
		return regionalAirport;
	}

	/**
	 * The Regional_airport Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("regional_airport")
	public void setRegionalAirport(Boolean regionalAirport) {
		this.regionalAirport = regionalAirport;
	}

	/**
	 * The Location Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}

	/**
	 * The Location Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("location")
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * The Currency_code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * The Currency_code Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * The Timezone Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("timezone")
	public String getTimezone() {
		return timezone;
	}

	/**
	 * The Timezone Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("timezone")
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * The Country Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("country")
	public Country getCountry() {
		return country;
	}

	/**
	 * The Country Schema
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("country")
	public void setCountry(Country country) {
		this.country = country;
	}

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

}
