package com.klm.exercise.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.klm.exercise.config.ApplicationContextConfig;

/**
 * @author Chee-Hong Hsia
 * This AppInitializerr class will be replacing the standard web.xml file.
 */
public class AppInitializer implements WebApplicationInitializer{

	private static final String MAPPING_URL = "/";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(appContext));
		
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping(MAPPING_URL);
		
	}

}
