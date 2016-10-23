package com.diaries.wedding.controllers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.diaries.wedding.model.Book;
import com.diaries.wedding.repository.BookRepository;
import com.mongodb.gridfs.GridFSDBFile;



@RestController
@RequestMapping("/book")
public class BookController {

  private final GridFsTemplate gridFsTemplate;
	
  @Autowired
  private BookRepository bookRepository;
 
  
  

  @Autowired
  public BookController(GridFsTemplate gridFsTemplate) {
    this.gridFsTemplate = gridFsTemplate;
  }
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
    Book book = new Book(bookMap.get("name").toString(), 
        bookMap.get("isbn").toString(),
        bookMap.get("author").toString(),
        Integer.parseInt(bookMap.get("pages").toString()));
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Book created successfully");
    response.put("book", bookRepository.save(book));
    return response;
  }
  
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

  @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
  public Book getBookDetails(@PathVariable("bookId") String bookId){
    return bookRepository.findOne(bookId);
  }
  

  @RequestMapping(value = "/image/{name:.+}", method = RequestMethod.GET)
  public HttpEntity<byte[]> get(@PathVariable("name") String name) {
      try {
        Optional<GridFSDBFile> optionalCreated = maybeLoadFile(name);
        if (optionalCreated.isPresent()) {
          GridFSDBFile created = optionalCreated.get();
          ByteArrayOutputStream os = new ByteArrayOutputStream();
          created.writeTo(os);
          HttpHeaders headers = new HttpHeaders();
          headers.add(HttpHeaders.CONTENT_TYPE, created.getContentType());
          return new HttpEntity<>(os.toByteArray(), headers);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      } catch (IOException e) {
        return new ResponseEntity<>(HttpStatus.IM_USED);
      }
  }
  
  
  
  @RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
  public Map<String, Object> editBook(@PathVariable("bookId") String bookId, 
      @RequestBody Map<String, Object> bookMap){
    Book book = new Book(bookMap.get("name").toString(), 
        bookMap.get("isbn").toString(),
        bookMap.get("author").toString(),
        Integer.parseInt(bookMap.get("pages").toString()));
    book.setId(bookId);
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Book Updated successfully");
    response.put("book", bookRepository.save(book));
    return response;
  }
  
  
  @RequestMapping(method = RequestMethod.DELETE, value="/{bookId}")
  public Map<String, String> deleteBook(@PathVariable("bookId") String bookId){
    bookRepository.delete(bookId);
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", "Book deleted successfully");
    
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public Map<String, Object> getAllBooks(){
    List<Book> books = bookRepository.findAll();
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("totalBooks", books.size());
    response.put("books", books);
    return response;
  }
  
  private Optional<GridFSDBFile> maybeLoadFile(String name) {
	    GridFSDBFile file = gridFsTemplate.findOne(getFilenameQuery(name));
	    return Optional.ofNullable(file);
	  }

	  private static Query getFilenameQuery(String name) {
	    return Query.query(GridFsCriteria.whereFilename().is(name));
	  }
}
