package com.klm.exercise.service;

import java.util.List;
import java.util.Map;

import com.klm.exercise.model.Destinations;

/**
 * @author Chee-Hong Hsia <br>
 * Interface of the DestinationFinderService. This interface provides a set of search methods to find your destinations.
 */
public interface IDestinationFinderService {

	/**
	 * Find a destination based on the given criteria given by the user.
	 * @param searchCriteria
	 * @return a list of DesitinationsResponseWrapper
	 */
	public List<Destinations> findDestination(Map<String, Object> searchCriteria);


}
