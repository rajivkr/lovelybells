package com.diaries.wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.diaries.wedding.model.Car;
import com.diaries.wedding.repository.CarMongoRepository;
import com.diaries.wedding.repository.CarSearchRepository;

@Controller
public class CarController {

	@Autowired
	CarMongoRepository carRepository;
	
	@Autowired
	CarSearchRepository carSearchRepository;
	
	@RequestMapping("/health")
	public String health() {
		return "<html><head><h1>Lovely Bells</h1></head></html>";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("carList", carRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Car car) {
		carRepository.save(car);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("carList", carSearchRepository.searchCars(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}
