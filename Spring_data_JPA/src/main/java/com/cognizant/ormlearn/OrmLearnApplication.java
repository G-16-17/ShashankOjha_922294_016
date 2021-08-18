package com.cognizant.ormlearn;

import java.util.List;
import com.cognizant.ormlearn.model.Country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService service;
	

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Application Started....");
		service=context.getBean(CountryService.class);
		testGetAllCountries();
	}
		public static void testGetAllCountries() {
			LOGGER.info("start");
			/*
			 * List<Country> countryList=service.getAllCountries();
			 * LOGGER.info("Countries : {}",countryList); LOGGER.info("End");
			 */
			
			try {
				Country country=service.findCountryByCode("IN");
				LOGGER.info("Country :{}",country);
			}
			catch(CountryNotFoundException e)
			{
				LOGGER.error(e.getMessage());
			}
			LOGGER.info("end");
		}
		
		public static void testAddCountry()
		{
			LOGGER.info("Start");
			Country country=new Country("MM","New Country");
			service.addCountry(country);
			LOGGER.info("end");
		}
		
		public static void testUpdateCountry()
		{
			LOGGER.info("Start");
			try {
				service.updateCountry("MM", "New Country Modified");
			}
			catch(CountryNotFoundException e)
			{
				LOGGER.error(e.getMessage());
			}
			LOGGER.info("end");
		}
		
		public static void testDeleteCountry()
		{
			LOGGER.info("Start");
			
			service.deleteCountry("MM");
			LOGGER.info("end");
		}
}

  
