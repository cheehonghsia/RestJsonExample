package com.klm.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Chee-Hong Hsia This is the controller class initiate the index page
 */
@Controller
public class RootController {

	/**
	 * Map incoming GET to index.jsp.
	 * @return index.jsp
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String initiateWelcomePage() {
		return "index";
	}

}
