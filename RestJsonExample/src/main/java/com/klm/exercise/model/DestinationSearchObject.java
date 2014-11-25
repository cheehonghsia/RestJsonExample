package com.klm.exercise.model;

import java.math.BigDecimal;

/**
 * @author Chee-Hong Hsia
 * Create a DestinationSearchObject to able to search for a specific destination. 
 */

public class DestinationSearchObject {
 
	private String originCode;
	private String pointOfSaleCode;
	private BigDecimal minBudget; // optional
	private BigDecimal maxBudget;
	
	/**
	 * Default constructor.
	 */
	public DestinationSearchObject() {
		super();
	}

	/**
	 * Instantiate DestinationSearchObject constructor with the following parameters:
	 * @param origin - origin code i.e. AMS.
	 * @param pos - point of sale code i.e. NL
	 * @param maxBudget - maximum budget
	 */
	public DestinationSearchObject(String originCode, String pointOfSaleCode, BigDecimal maxBudget){
		this.originCode = originCode;
		this.pointOfSaleCode = pointOfSaleCode;
		this.maxBudget = maxBudget;
	}	
	
	/**
	 * Instantiate DestinationSearchObject constructor with the following parameters:
	 * @param origin - origin code i.e. AMS.
	 * @param pos - point of sale code i.e. NL
	 * @param minBudget - minimum budget
	 * @param maxBudget - maximum budget
	 */
	public DestinationSearchObject(String originCode, String pointOfSaleCode, BigDecimal minBudget, BigDecimal maxBudget){
		this.originCode = originCode;
		this.pointOfSaleCode = pointOfSaleCode;
		this.minBudget = minBudget;
		this.maxBudget = maxBudget;
	}

	public String getOriginCode() {
		return originCode;
	}

	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}

	public String getPointOfSaleCode() {
		return pointOfSaleCode;
	}

	public void setPointOfSaleCode(String pointOfSaleCode) {
		this.pointOfSaleCode = pointOfSaleCode;
	}

	public BigDecimal getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(BigDecimal minBudget) {
		this.minBudget = minBudget;
	}

	public BigDecimal getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(BigDecimal maxBudget) {
		this.maxBudget = maxBudget;
	}
}
