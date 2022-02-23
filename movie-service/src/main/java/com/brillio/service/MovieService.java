package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;

@Service
public class MovieService  {
	
	@Autowired
	private MovieRepository movieRepository;
	
	

	public Movie saveMovie(Movie movie) {
		
		return movieRepository.save(movie);
	}
	
	public Optional<Movie> findMovieById(Long id)
	{
		return movieRepository.findById(id);
		
		
		
	}
	
	public List<Movie> findAllMovies()
	{
		return movieRepository.findAll();
	}

}
