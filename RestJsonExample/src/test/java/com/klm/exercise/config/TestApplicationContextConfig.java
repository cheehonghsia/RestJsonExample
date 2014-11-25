package com.klm.exercise.config;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestApplicationContextConfig {
	
	private static RestTemplate restTemplate;
	
	@BeforeClass
	public static void setUp() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		
		restTemplate = (RestTemplate) context.getBean("restTemplate");
		
	}

	@Test
	public void testRestTemplat() {

		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
		
		
		
	}

}
