package com.cognizant.moviecruiser;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;


@SpringBootApplication
public class MoviecruiserApplication {
	
	
	private static final Logger LOGGER= LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static MovieService movieService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MoviecruiserApplication.class, args);
		movieService=context.getBean(MovieService.class);
	    
    	LOGGER.info("Inside Main.....");
    	
    	testGetAllMovieAdmin();
    	testGetAllMovieCustomer();
    	testModifyMovie();
		
	}
	
	public static void testGetAllMovieAdmin() {
		LOGGER.info("Start");
		List<Movie> movieList= movieService.getMovieListAdmin();
		LOGGER.debug("Movies= {}",movieList);
		LOGGER.info("End");
	}
	public static void testGetAllMovieCustomer() {
		LOGGER.info("Start");
		List<Movie> movieList= movieService.getMovieListCustomer();
		LOGGER.debug("Movies= {}",movieList);
		LOGGER.info("End");
	}
	public static void testModifyMovie() {
		LOGGER.info("Start");
		Date date=DateUtil.convertToDate("11/06/2019");
    	Movie movie = new Movie(3,"Fast and Furious","$5,187,463,944" ,true, date, "Action", true);
    	movieService.modifyMovie(movie);
    	Movie newMovie=movieService.getMovie(3);
    	LOGGER.debug("Movies= {}",newMovie);
		LOGGER.info("End");
	}

}
