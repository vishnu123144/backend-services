package com.brillio;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;

import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;
import com.brillio.services.MovieService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)//annotation that is used to register extensions for the annotated test class 
public class MovSerTest {

	@Mock
	private MovieRepository movieRepo;

	@InjectMocks
	private MovieService service;
	
	Optional<Movie> value;
	List<Movie> movieList=new ArrayList<>();

	static Movie movie1;
	static Movie movie2;
	@BeforeEach
	public void setUp() throws Exception {
		movie1 = new Movie(1l, "AB", 2001, "Drama");
		movie2 = new Movie(2l, "CD", 2021, "Comedy");
		value=Optional.of(movie1);
		movieList.add(movie1);
		movieList.add(movie2);
		
	}
	@AfterEach
	void tearDown() throws Exception {
		movieRepo.deleteAll();
		movie1 = null;
		movie2 = null;
	}
	@Test
	public void testSaveMovie() {
		// Adding the behaviour
		when(service.saveMovie(any())).thenReturn(movie1);
		Movie save = service.saveMovie(movie1);
		assertEquals(1l, save.getId());
		assertEquals("AB", save.getName());
		assertEquals(2001, save.getYear());
		assertEquals("Drama", save.getGenre());
		// Verify the Behaviour
    	verify(movieRepo, times(1)).save(movie1);

	}
	@Test
	public void testValidMovie()
	{
		service.saveMovie(movie1);
		service.saveMovie(movie2);
		when(movieRepo.findById(any())).thenReturn(value);
		Optional<Movie> findMovieById = service.findMovieById(1l);
		assertEquals("Drama",findMovieById.get().getGenre());
		verify(movieRepo,times(2)).save(any());
		verify(movieRepo,times(1)).findById(any());
	}
	
	@Test
	public void testFindAllMovies()
	{
		service.saveMovie(movie1);
		service.saveMovie(movie2);
		when(movieRepo.findAll()).thenReturn(movieList);
		List<Movie> list=service.findAllMovies();
		assertEquals(2,list.size());
		verify(movieRepo,times(1)).findAll();
		
	}
	
		
//	@Test
//	public void testValidFindMovie() {
//		
//        service.saveMovie(movie1);
//		service.saveMovie(movie2);
//		// Adding the behaviour
//		when(movieRepo.findById(any())).thenReturn(value);
//		Optional<Movie> findMovieById = service.findMovieById(1l);
//		
//		assertEquals("Drama", findMovieById.get().getGenre() );
//		//Only Mock Objects can be verified
//		verify(movieRepo,times(2)).save(any());
//		//verify(service,times(2)).saveMovie(any());
//		verify(movieRepo,times(1)).findById(any());
//	}
//	
//	@Test
//	public void testFindAllMovies() {
//		service.saveMovie(movie1);
//		service.saveMovie(movie2);
//		when(movieRepo.findAll()).thenReturn(movieList);
//		
//		List<Movie> list = service.findAllMovies();
//		assertEquals(2, list.size());
//		assertEquals("Comedy", list.get(1).getGenre());
//		assertEquals("Drama", list.get(0).getGenre());
//		
//		verify(movieRepo,times(1)).findAll();
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	

}
