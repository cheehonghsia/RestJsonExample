package com.klm.exercise.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.klm.exercise.model.DestinationSearchObject;
import com.klm.exercise.model.Destinations;
import com.klm.exercise.service.IDestinationFinderService;

/**
 * @author Chee-Hong Hsia <BR>
 * This is the controller class that receives all incoming requests and dispatch it to the appropriate view controller.
 */
@Controller
public class DestinationController {
	
	@Autowired private IDestinationFinderService destinationFinderService;
	
	/**
	 * Map incoming /destinations GET URI to destination.jsp.
	 * @return destination.jsp
	 */
	@RequestMapping(value="/destinations", method = RequestMethod.GET)
	public String initiateDestinationPage(ModelMap model){
		
		// create a DestinationSearchObject object for the commandName attribute in the JSP.
		model.addAttribute("destinationSearchObject", new DestinationSearchObject());
		
		return "destinations";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String searchForDestination(@ModelAttribute("destinationSearchObject") DestinationSearchObject searchObject, BindingResult bindingResult, SessionStatus status, ModelMap model) throws ClientProtocolException, IOException{
		
    	Map<String, Object> searchCriteria = new HashMap<String, Object>();
    	searchCriteria.put("origin", searchObject.getOriginCode());
    	searchCriteria.put("pos", searchObject.getPointOfSaleCode());
    	searchCriteria.put("minBudget", searchObject.getMinBudget());
    	searchCriteria.put("maxBudget", searchObject.getMaxBudget());

    	List<Destinations> destinations = destinationFinderService.findDestination(searchCriteria);		
    	
    	model.addAttribute("destinations", destinations);

		return "destinations";
	}



}
