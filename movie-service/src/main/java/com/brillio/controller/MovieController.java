package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.model.Movie;
import com.brillio.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	
	private MovieService movieService;
	
	@GetMapping("/get")
	public ResponseEntity<Object> getAllMovies()
	{
		List<Movie> findAllMovies=movieService.findAllMovies();
		return new ResponseEntity<>(findAllMovies,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveMovies(@RequestBody Movie movie){
	  Movie movie1 = movieService.saveMovie(movie);
	  if(movie1 != null) {
	   return new ResponseEntity<>(movie1, HttpStatus.CREATED); 
	  }
	  else{
	   return new ResponseEntity<>(movie1, HttpStatus.CONFLICT);
	  }
}


}
