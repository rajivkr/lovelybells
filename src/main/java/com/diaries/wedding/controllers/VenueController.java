package com.diaries.wedding.controllers;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;

import com.diaries.wedding.model.*;
import com.diaries.wedding.repository.VenueRepository;


@RestController
@RequestMapping("/venue")
public class VenueController {
	
	private final GridFsTemplate gridFsTemplate;
	@Autowired
	private VenueRepository venueRepository;
	
	  @Autowired
	  public VenueController(GridFsTemplate gridFsTemplate) {
	    this.gridFsTemplate = gridFsTemplate;
	  }
	  
	  //Posting of Venue
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Object> createVenue(@RequestBody Venue venue){
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Venue inserted successfully");
	    response.put("venue", venueRepository.save(venue));
	    return response;
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Venue> getVenue(){
		List<Venue> ven=venueRepository.findAll();
		
	    return ven;
	}
	
	// For Update Venue
	@RequestMapping(method=RequestMethod.POST,value="/update")
	public Map<String, Object> Update(@RequestBody Venue venue){
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Venue updated successfully");
	    response.put("venue", venueRepository.save(venue));
	    return response;
	}
	//Search based on location
/*	public Venue[] searchLoc(String locname){
		//venueRepository.find()
		
		Venue v[]=new Venue[10];
		return v;
	}*/
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Venue searchById(@PathVariable("id")String id){
		Venue ven=(Venue) venueRepository.findById(id);

	    return ven;
	}
	@RequestMapping(path = "/location/{state}/{city}", method = RequestMethod.GET)
	public List<Venue> searchLoc(@PathVariable("state")String state,@PathVariable("city")String city){
		/*Query query=new Query();
		query.addCriteria(Criteria.where("state").is(state))*/
		List<Venue> ven=venueRepository.getAllStateAndCity(state,city);
		//List<Venue> ven=venueRepository.findByState(state);
		/*Query q=new Query();
		q.fields().
		venueRepository.findAll(Veune.)*/
		return ven;
	}
	
	/*@RequestMapping(value = {"/location/", "/location"}, method = RequestMethod.GET)
	public List<ShortVenueDetails> searchLoc1(@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("area") String area){
		List<ShortVenueDetails> ven=venueRepository.findByStateOrCityOrArea(state, city,area);
		return ven;
	}*/
	/*@RequestMapping(value = {"/halls/", "/halls"}, method = RequestMethod.GET)
	public List<Halls> searchHalls(@RequestParam("hallName")String hallName){
		//List<Halls> hal=venueRepository.findByHalls_HallName(hallName);
		venueRepository.fi
		
		//return hal;
	}*/
	 //Posting of Image
	  @RequestMapping(method = RequestMethod.POST,value="/image")
	  public HttpEntity<byte[]> createOrUpdate(@RequestParam("file") MultipartFile file) {
	    String name = file.getOriginalFilename();
	    try {
	      Optional<GridFSDBFile> existing = maybeLoadFile(name);
	      if (existing.isPresent()) {
	        gridFsTemplate.delete(getFilenameQuery(name));
	      }
	      gridFsTemplate.store(file.getInputStream(), name, file.getContentType()).save();
	      String resp = "<script>window.location = '/';</script>";
	      return new HttpEntity<>(resp.getBytes());
	    } catch (IOException e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  private Optional<GridFSDBFile> maybeLoadFile(String name) {
		    GridFSDBFile file = gridFsTemplate.findOne(getFilenameQuery(name));
		    return Optional.ofNullable(file);
		  }
	  private static Query getFilenameQuery(String name) {
		    return Query.query(GridFsCriteria.whereFilename().is(name));
		  }
}
