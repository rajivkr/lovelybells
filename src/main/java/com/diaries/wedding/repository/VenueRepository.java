package com.diaries.wedding.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.diaries.wedding.model.Venue;

public interface VenueRepository extends MongoRepository<Venue, String> {

	@Query(value = "{ 'state' : ?0 , 'city' : ?0} ", fields = "{ 'name' : 1, 'state' : 1,'address':1,'shortDescr':1,'otherHighlights':1,'vegPrice':1,'nonVegPrice':1,'city':1,'area':1}")
	List<Venue> getAllStateAndCity(String state, String city);

	// List<Venue> findByStateOrCityOrArea(String state,String city,String
	// area);
	// List<Venue> findByState(String state);
	Venue findById(String id);

	// @Query(value="{ 'firstname' : ?0 }", fields="{ 'firstname' : 1,
	// 'lastname' : 1}")
	// List<Halls> findByHalls_HallName(String hallName);
	@Query(value = "{} ", fields = "{ 'name' : 1, 'state' : 1,'address':1,'shortDescr':1,'otherHighlights':1,'vegPrice':1,'nonVegPrice':1,'city':1,'area':1,'venueRent':1}")
	List<Venue> findAll();
}
