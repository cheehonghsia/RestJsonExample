package com.klm.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Chee-Hong Hsia
 * This class represents the Coordinates element of the JSON response call.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
	
	private String lat;
	private String lon;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

}
