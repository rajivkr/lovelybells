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

import com.diaries.wedding.controllers.PhotographyController;
import com.diaries.wedding.model.Photography;
import com.diaries.wedding.repository.PhotographyRepository;

@RunWith(MockitoJUnitRunner.class)
public class PhotographyControllerTest {

	@Mock
	private PhotographyRepository photographyRepository;

	@Mock
	private Photography photo;

	@InjectMocks
	PhotographyController photoController;

	@Before
	public void setUp() throws Exception {
		photo = new Photography();
	}

	@Test
	public void testCreateVenue() {
		photo.setFullAddress(" ");
		photoController.createPhotography(photo);
	}

	@Test
	public void testGetVenue() {
		List<Photography> photoList = new ArrayList<Photography>();
		photoList.add(new Photography());
		when(photographyRepository.findAll()).thenReturn(photoList);
		photoController.getPhotography();
	}

	@Test
	public void testUpdateVenue() {
		photo.setArea(" ");
		photoController.updatePhotography(photo);
	}

	@Test
	public void testDeleteVenue() {
		photoController.deletePhotography("1");
	}

	@Test
	public void testSearchById() {
		when(photographyRepository.findById(Mockito.anyString())).thenReturn(photo);
		photoController.searchById(Mockito.anyString());

	}
}
