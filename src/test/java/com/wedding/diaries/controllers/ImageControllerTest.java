package com.wedding.diaries.controllers;


import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.diaries.wedding.controllers.ImageController;
import com.mongodb.gridfs.GridFSDBFile;


@RunWith(MockitoJUnitRunner.class)
public class ImageControllerTest {
	
	@Mock
	private GridFsTemplate gridFsTemplate;
	
	@Mock
	private GridFSDBFile file;
	
	@Mock
	private MultipartFile mpFile;
	
	@InjectMocks
	public ImageController imgController;
	
	@Before
	public void setUp() throws Exception {
		file = new GridFSDBFile();
	}
	
	@Test
	public void testMayLoadFile(){
		when(gridFsTemplate.findOne(Mockito.any())).thenReturn(file);
		imgController.maybeLoadFile(Mockito.anyString());
	}
	
	@Test
	public void testMayLoadFileNull(){
		when(gridFsTemplate.findOne(Mockito.any())).thenReturn(null);
		imgController.maybeLoadFile(Mockito.anyString());
	}
	
	
/*	@Test
	public void testCreateOrUpdate(){
		Optional<GridFSDBFile> optional = null;
		when(mpFile.getOriginalFilename()).thenReturn(" ");
		when(imgController.maybeLoadFile(Mockito.anyString())).thenReturn(optional);
		when(optional.isPresent()).thenReturn(true);
		imgController.createOrUpdate(mpFile);
		
	}*/

	@Test
	public void getPassword() {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		String encodedPass = encode.encode("test123");
		System.out.println("password is " + encodedPass);
	}
}
