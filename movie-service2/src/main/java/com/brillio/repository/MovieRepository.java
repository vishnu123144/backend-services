package com.brillio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long>{
	
	//query methods
	Movie findByMovieName(String movieName);

}
