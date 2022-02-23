package com.brillio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.model.Movie1;

public interface Movie1Repository extends JpaRepository<Movie1,Long> {

	 Movie1 findMovieName(String name);

}
