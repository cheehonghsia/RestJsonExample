package com.klm.exercise.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Chee-Hong Hsia
 * This class represents the Destination element of the JSON response call.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Destination {

	private String code;
	private String name;
	private String description;
	private String country;
	private String continent;
	private Coordinates coordinates;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}


}
