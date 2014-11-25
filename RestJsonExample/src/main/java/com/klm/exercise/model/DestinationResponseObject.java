package com.klm.exercise.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Chee-Hong Hsia
 * This class represents the root object of the response. 
 * This class needs the @JsonIgnoreProperties because it's not in the JSON response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinationResponseObject {
	
	@JsonProperty("destinations")
	private List<Destinations> destinations;
	
	public List<Destinations> getDestinations() {
		return destinations;
	}
	
	public void setDestinations(List<Destinations> destinations) {
		this.destinations = destinations;
	}
}
