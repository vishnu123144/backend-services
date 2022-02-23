package com.brillio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;
import com.brillio.services.MovieService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServieTest {
	
	@Mock
	private MovieRepository movieRepo;
	
	@InjectMocks
	private MovieService service;
	
	
	Movie movie1;
	Movie movie2;
	@Before
	public void setUp() throws Exception {
		movie1=new Movie(1l,"AB",2001,"Drama");
		movie2=new Movie(2l,"CD",2021,"Comedy");
		
	}
	@After
	public void tearDown() throws Exception {
	   movie1=null;
	   movie2=null;
	}
	@Test
	public void testSaveMovie() {
		when(service.saveMovie(movie1)).thenReturn(movie1);
		Movie saveMovie = service.saveMovie(movie1);
		assertEquals(movie1.getId(), saveMovie.getId());
		assertEquals(movie1.getName(), saveMovie.getName());
		assertEquals(movie1.getYear(), saveMovie.getYear());
		assertEquals(movie1.getGenre(), saveMovie.getGenre());
		
		verify(service,times(1)).saveMovie(movie1);
	
	}

}
