package com.brillio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brillio.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {

	List<Book> findAll();

	Book save(Book book);

}
