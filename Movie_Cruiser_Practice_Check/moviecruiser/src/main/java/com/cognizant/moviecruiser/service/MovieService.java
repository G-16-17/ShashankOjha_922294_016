package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Transactional
	public List<Movie> getMovieListAdmin(){
		return movieRepository.findAll();
	}

	@Transactional
	public List<Movie> getMovieListCustomer(){
		return movieRepository.findByActiveNotAndDateOfLaunchBefore(true, new Date());
	}

	@Transactional
	public Movie getMovie(long id) {
		return movieRepository.findById(id).get();
	}
	
	public void modifyMovie(Movie movienew) {
		Movie movieold= movieRepository.findById(movienew.getId()).get();
		movieold=movienew;
		movieRepository.save(movieold);
		
	}
}
