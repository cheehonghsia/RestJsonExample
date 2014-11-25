package com.klm.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Chee-Hong Hsia
 * This class represents the Root element of the JSON response call.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Destinations {
	
	private String origin;
	
	private Destination destination;
	
	private LowestFare lowestFare;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public LowestFare getLowestFare() {
		return lowestFare;
	}

	public void setLowestFare(LowestFare lowestFare) {
		this.lowestFare = lowestFare;
	}

}
