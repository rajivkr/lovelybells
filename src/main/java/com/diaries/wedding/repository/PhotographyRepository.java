package com.diaries.wedding.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.diaries.wedding.model.Photography;

public interface PhotographyRepository extends MongoRepository<Photography, String> {
	List<Photography> findAll();

	Photography findById(String id);
}
