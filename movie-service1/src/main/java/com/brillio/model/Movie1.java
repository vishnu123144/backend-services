package com.brillio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Movie1 {
	@Id
	private Long id;
	private String movieName;
	private int year;
	private String genre;
	
	public Movie1()
	{
		
	}
	
	
	public Movie1(Long id, String movieName, int year, String genre) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.year = year;
		this.genre = genre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return movieName;
	}
	public void setName(String name) {
		this.movieName = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}
