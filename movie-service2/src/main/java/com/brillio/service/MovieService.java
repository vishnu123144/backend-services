package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	
	public Movie saveMovie(Movie movie)
	{
		return repository.save(movie);
	}
	
	public List<Movie> getAllMovie()
	{
		return repository.findAll();
	}
	
	public Movie findMovieById(Long id)
	{
		Optional<Movie> movie=repository.findById(id);
		if(movie.isPresent())
		{
			return movie.get();
		}
		return null;
	}

}
