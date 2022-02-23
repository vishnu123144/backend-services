package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.brillio.model.Movie1;
import com.brillio.model.Movie1;
import com.brillio.repository.Movie1Repository;


public class Movie1Service {
	@Autowired
	private Movie1Repository movieRepository;
	
	

	public Movie1 saveMovie(Movie1 movie) {
		
		return movieRepository.save(movie);
	}
	
	public Optional<Movie1> findMovieById(Long id)
	{
		return movieRepository.findById(id);
		
		
		
	}
	
	public List<Movie1> findAllMovies()
	{
		return movieRepository.findAll();
	}


}
