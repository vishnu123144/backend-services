package com.brillio;



import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;
import com.brillio.model.Movie;
import com.brillio.repository.MovieRepository;
import com.brillio.service.MovieService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

	
	@Mock
	private MovieRepository movieRepo;
	
	@InjectMocks
	private MovieService service;
	
	
	static Movie movie1;
	static Movie movie2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		movie1=new Movie(1l,"AB",2000,"Drama");
		movie2=new Movie(2l,"CD",2020,"Comedy");
	}

	@AfterEach
	public void tearDown() throws Exception {
		movieRepo.deleteAll();
		movie1=null;
		movie2=null;
	}

	@Test
	public void testSaveMovie() {
		when(service.saveMovie(any())).thenReturn(movie1);
		Movie save=service.saveMovie(movie1);
		
		assertEquals("AB",save.getName());
		assertEquals("Drama",save.getGenre());
		assertEquals(2000,save.getYear());
		
		verify(movieRepo,times(1)).save(movie1);
	}


}
