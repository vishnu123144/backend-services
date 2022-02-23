package com.brillio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;

import com.brillio.controller.MovieController;
import com.brillio.model.Movie;
import com.brillio.service.MovieService;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {
	
	@Autowired
	MockMvc mockMvc;
    @Mock
    private MovieService movieService;
    
    @InjectMocks
    private MovieController controller;
    
    Optional<Movie> value;
	List<Movie> movieList=new ArrayList<>();
	
	static Movie movie1;
	static Movie movie2;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		// Build a MockMvc instance by registering one or more @Controller instances and
		  // configuring Spring MVC
		  mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		  movie1=new Movie(1l,"AB",2001,"Drama");
			movie2=new Movie(2l,"CD",2021,"Comedy");
			value=Optional.of(movie1);
			  movieList.add(movie1);
			  movieList.add(movie2);

	}

	@AfterEach
	void tearDown() throws Exception {
		movie1=null;
		movie2=null;
	}

	@Test
	void testGetAllMovies() {
		movieService.saveMovie(movie1);
		movieService.saveMovie(movie2);
	}

}
