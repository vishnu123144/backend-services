package com.brillio;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import com.brillio.controller.MovieController;
import com.brillio.model.Movie;
import com.brillio.services.MovieService;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
	//Main entry point for server-side Spring MVC test support. 
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	private MovieService movService;
	
	@InjectMocks
	private MovieController movController;
	
	Optional<Movie> value;
	List<Movie> movieList=new ArrayList<>();

	static Movie movie1;
	static Movie movie2;
	@BeforeEach
	public void setUp() throws Exception {
		// Build a MockMvc instance by registering one or more @Controller instances and
		// configuring Spring MVC
		mockMvc = MockMvcBuilders.standaloneSetup(movController).build();
		movie1 = new Movie(1l, "AB", 2001, "Drama");
		movie2 = new Movie(2l, "CD", 2021, "Comedy");
		value=Optional.of(movie1);
		movieList.add(movie1);
		movieList.add(movie2);
		
	}
	@AfterEach
	void tearDown() throws Exception {
		movie1 = null;
		movie2 = null;
	}

	@Test
	void testGetAllMovies() {
		movService.saveMovie(movie1);
		movService.saveMovie(movie2);
			when(movService.findAllMovies()).thenReturn(movieList);
			
			try {
				mockMvc.perform(get("/get").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		try {
//			mockMvc.perform(get("/get").contentType(MediaType.APPLICATION_JSON))
//			        .andExpect(status().isOk())
//			        .andDo(MockMvcResultHandlers.print());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		verify(movService,times(1)).findAllMovies();
	}
	
	
	
	@Test
	public void testSavemovies()
	{
		when(movService.saveMovie(any())).thenReturn(movie1);
		movService.saveMovie(movie1);
		try {
			mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON))
			       .andExpect(status().isCreated())
			       .andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verify(movService,times(1)).saveMovie(any());
	}
//	@Test
//	public void testSaveMovies() {
//		
//		when(movService.saveMovie(any())).thenReturn(movie1);
//		 movService.saveMovie(movie1);
//		
//		try {
//			mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON))
//			       .andExpect(status().isCreated())
//			        .andDo(MockMvcResultHandlers.print());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		verify(movService,times(1)).saveMovie(any());
//	
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//	
//	

}
