package com.diaries.wedding.repository;

import org.springframework.data.repository.CrudRepository;

import com.diaries.wedding.model.Car;

public interface CarMongoRepository extends CrudRepository<Car, String>{}