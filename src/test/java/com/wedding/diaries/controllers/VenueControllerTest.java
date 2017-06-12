package com.wedding.diaries.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.diaries.wedding.controllers.VenueController;
import com.diaries.wedding.model.Venue;
import com.diaries.wedding.repository.VenueRepository;

@RunWith(MockitoJUnitRunner.class)
public class VenueControllerTest {


	@Mock
	private VenueRepository venueRepository;

	@Mock
	private Venue venue;

	@InjectMocks
	VenueController venueController;

	@Before
	public void setUp() throws Exception {
		venue = new Venue();
	}

	@Test
	public void testCreateVenue() {
		venue.setAddress(" ");
		venueController.createVenue(venue);
	}

	@Test
	public void testGetVenue() {
		List<Venue> venueList = new ArrayList<Venue>();
		venueList.add(new Venue());
		when(venueRepository.findAll()).thenReturn(venueList);
		venueController.getVenue();
	}

	@Test
	public void testUpdateVenue() {
		venue.setArea(" ");
		venueController.updateVenue(venue);
	}

	@Test
	public void testDeleteVenue() {
		venueController.deleteVenue("1");
	}

	@Test
	public void testSearchById() {
		when(venueRepository.findById(Mockito.anyString())).thenReturn(venue);
		venueController.searchById(Mockito.anyString());

	}

	@Test
	public void testSearchByLocationAndCity() {
		when(venueRepository.getAllStateAndCity(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(new ArrayList<Venue>());
		venueController.searchLoc(Mockito.anyString(), Mockito.anyString());
	}
	
	@Test
	public void testCreateOrUpdate() {
		
	}
}
