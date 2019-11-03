
package com.qantas.airport.domain.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Country Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "display_name"
})
public class Country {

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

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

}
