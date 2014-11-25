package com.klm.exercise.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.klm.exercise.aop.DestinationFinderAdvice;
import com.klm.exercise.controller.DestinationController;
import com.klm.exercise.controller.RootController;
import com.klm.exercise.service.DestinationFinderService;

/**
 * @author Chee-Hong Hsia
 * This class replace the standard applicationContext.xml.
 */
@Configuration
@EnableWebMvc // equivalent to <mvc:annotation-driven />
@EnableAspectJAutoProxy // equivalent to <aop:aspectj-autoproxy>
@PropertySource(value = { "service-endpoint.properties" }) // equivalent to <context:property-placeholder
@ComponentScan(basePackageClasses = {DestinationFinderService.class, DestinationFinderAdvice.class, DestinationController.class, RootController.class})
public class ApplicationContextConfig {

	@Bean(name ="restTemplate")
	public RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*
     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
     * Remove this bean if you are not using @Value annotations for injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
