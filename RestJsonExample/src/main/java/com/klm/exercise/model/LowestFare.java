package com.klm.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Chee-Hong Hsia
 * This class represents the LowestFare element of the JSON response call.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LowestFare {
	
	private String value;
	
	private String currency;
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
