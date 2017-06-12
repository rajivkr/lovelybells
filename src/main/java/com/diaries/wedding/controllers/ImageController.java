package com.diaries.wedding.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private GridFsTemplate gridFsTemplate;

	// Posting of Image
	@RequestMapping(method = RequestMethod.POST, value = "/image")
	public HttpEntity<byte[]> createOrUpdate(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();
		try {
			Optional<GridFSDBFile> existing = maybeLoadFile(name);
			if (existing.isPresent()) {
				gridFsTemplate.delete(Query.query(GridFsCriteria.whereFilename().is(name)));
			}
			gridFsTemplate.store(file.getInputStream(), name, file.getContentType()).save();
			String resp = "<script>window.location = '/';</script>";
			return new HttpEntity<>(resp.getBytes());
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public Optional<GridFSDBFile> maybeLoadFile(String name) {
		GridFSDBFile file = gridFsTemplate.findOne(Query.query(GridFsCriteria.whereFilename().is(name)));
		return Optional.ofNullable(file);
	}
}
