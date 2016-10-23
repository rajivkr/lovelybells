package com.diaries.wedding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diaries.wedding.model.Book;


public interface BookRepository extends MongoRepository<Book, String>{

}
