package com.cognizant.moviecruiser.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecruiser.model.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("select m from Movies m where m.movie_active=?1 and m.date_of_launch<?2")
	List<Movie> findByActiveNotAndDateOfLaunchBefore(boolean active,Date dateOfLaunch);

}
