package com.klm.exercise.service;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.klm.exercise.model.DestinationResponseObject;
import com.klm.exercise.model.Destinations;

public class TestDestinationFinderService {

	private static final String REST_CALL = "http://www.klm.com/destinations/destination-finder/?origin=AMS&pos=NL&minBudget=100&maxBudget=116";

	private MockRestServiceServer mockServer;

	private RestTemplate restTemplate;

	@Before
	public void setup() {
		this.restTemplate = new RestTemplate();
		this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
	}

	@Test
	public void findDestination() {
		
		Map<String, Object> searchCriteria = new HashMap<String, Object>();
    	searchCriteria.put("origin", "AMS");
    	searchCriteria.put("pos", "NL");
    	searchCriteria.put("minBudget", 100);
    	searchCriteria.put("maxBudget", 116);
		
		String responseBody = "{\"destinations\":[{\"origin\":\"AMS\",\"destination\":{\"code\":\"MIL\",\"name\":\"Milan\",\"description\":\"Milan (MIL)\",\"country\":\"IT\",\"continent\":\"EUR\",\"coordinates\":{\"lat\":45.46417,\"lon\":9.20167}},\"lowestFare\":{\"value\":116.0,\"currency\":\"EUR\"}}]}";
		
		this.mockServer.expect(requestTo(REST_CALL)).andExpect(method(HttpMethod.GET))
		.andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));
		
		List<Destinations> destinations = restTemplate.getForObject(REST_CALL, DestinationResponseObject.class, searchCriteria).getDestinations();
		
		Assert.assertNotNull(destinations);
		Assert.assertEquals(1, destinations.size()); 
		
		for(Destinations dest : destinations){
			
			Assert.assertEquals("AMS", dest.getOrigin());
			Assert.assertEquals("MIL", dest.getDestination().getCode());
		}
		
		this.mockServer.verify();
		
	}

}
