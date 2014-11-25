/**
 * 
 */
package com.klm.exercise.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import com.klm.exercise.model.DestinationResponseObject;
import com.klm.exercise.model.Destinations;

/**
 * @author Chee-Hong Hsia
 * Concrete class of the IDestinationFinderService interface.
 * This class uses the RestTemplate to make the call to the URL specified in the endpointURL.
 */

@Service
public class DestinationFinderService implements IDestinationFinderService {
	
	@Autowired private RestOperations restTemplate; 
	@Value("${service.df.endpoint}") private String endpointURL;
	
	@Override
	public List<Destinations> findDestination(Map<String, Object> searchCriteria) {

		return this.restTemplate.getForObject(endpointURL+"?origin={origin}&pos={pos}&minBudget={minBudget}&maxBudget={maxBudget}", DestinationResponseObject.class, searchCriteria).getDestinations();

	}

}
