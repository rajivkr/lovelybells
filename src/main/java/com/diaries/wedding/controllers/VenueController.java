package com.diaries.wedding.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diaries.wedding.model.Venue;
import com.diaries.wedding.repository.VenueRepository;

@RestController
@RequestMapping("/rest/venue")
public class VenueController {

	@Autowired
	private VenueRepository venueRepository;

	// Posting of Venue
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createVenue(@RequestBody Venue venue) {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Venue inserted successfully");
		response.put("venue", venueRepository.save(venue));
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Venue> getVenue() {
		List<Venue> ven = venueRepository.findAll();
		return ven;
	}

	// For Update Venue
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public Map<String, Object> updateVenue(@RequestBody Venue venue) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Venue updated successfully");
		response.put("venue", venueRepository.save(venue));
		return response;
	}

	// For Delete Venue
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteVenue(@PathVariable("id") String id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		venueRepository.delete(id);
		response.put("message", "Venue Deleted Successfully");
		return response;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Venue searchById(@PathVariable("id") String id) {
		Venue ven = (Venue) venueRepository.findById(id);
		return ven;
	}

	@RequestMapping(path = "/location/{state}/{city}", method = RequestMethod.GET)
	public List<Venue> searchLoc(@PathVariable("state") String state, @PathVariable("city") String city) {
		List<Venue> ven = venueRepository.getAllStateAndCity(state, city);
		return ven;
	}
}
