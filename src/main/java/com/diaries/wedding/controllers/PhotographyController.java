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

import com.diaries.wedding.model.Photography;
import com.diaries.wedding.repository.PhotographyRepository;

@RestController
@RequestMapping("/rest/photography")
public class PhotographyController {

	@Autowired
	private PhotographyRepository photographyRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createPhotography(@RequestBody Photography photography) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Photography inserted successfully");
		response.put("photography", photographyRepository.save(photography));
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Photography> getPhotography() {
		List<Photography> photo = photographyRepository.findAll();
		return photo;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public Map<String, Object> updatePhotography(@RequestBody Photography photography) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Photography updated successfully");
		response.put("photography", photographyRepository.save(photography));
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deletePhotography(@PathVariable("id") String id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		photographyRepository.delete(id);
		response.put("message", "Photography Deleted Successfully");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Photography searchById(@PathVariable("id") String id) {
		Photography photography = (Photography) photographyRepository.findById(id);
		return photography;
	}
}
