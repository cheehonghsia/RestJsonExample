package com.klm.exercise.aop;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klm.exercise.service.DestinationFinderService;


/**
 * @author Chee-Hong Hsia
 * Aspect class for logging activities in the DestinationFinderService class so that the core and "plumbing" code is separated.
 */
@Aspect
@Component
public class DestinationFinderAdvice {
	
	@Autowired private static final Logger logger = LoggerFactory.getLogger(DestinationFinderService.class);
	
	@Before("execution(* com.klm.exercise.service.DestinationFinderService.findDestination(..)) && args(searchCriteria)")
	public void findDestinationsAdvice(JoinPoint joinPoint, Map<String, Object> searchCriteria){
		
		logger.debug("Search params {}", searchCriteria);
		
	}

}
