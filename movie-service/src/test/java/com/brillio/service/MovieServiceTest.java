package com.brillio.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
	 
		@Mock
		private MovieRepository movieRepository;
		
		@InjectMocks
		private MovieService service;
		
		Optional<Movie> value;
		List<Movie> movieList=new ArrayList<>();
		
		static Movie movie1;
		static Movie movie2;


		@BeforeEach
		public void setUp() throws Exception {
			movie1=new Movie(1l,"AB",2001,"Drama");
			movie2=new Movie(2l,"CD",2021,"Comedy");
			
		}

		@AfterEach
		public void tearDown() throws Exception {
		
			movie1=null;
			movie2=null;
			
		}

		@Test
		public void testSaveMovie() {
			//adding behaviour
			when(service.saveMovie(any())).thenReturn(movie1);
			  Movie saveMovie = service.saveMovie(movie1);
			  assertEquals(movie1.getId(), saveMovie.getId());
			  assertEquals(movie1.getName(), saveMovie.getName());
			  assertEquals(movie1.getYear(), saveMovie.getYear());
			  assertEquals(movie1.getGenre(), saveMovie.getGenre());
			//verifying behaviour 
			  verify(service,times(1)).saveMovie(movie1);
			 
			
		}
		
	
	
	

}
