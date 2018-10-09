package com.verizon.bsa.restapi;

import java.awt.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.bsa.model.Book;
import com.verizon.bsa.service.BookService;

@RestController
@RequestMapping("/books")
public class BookAPI {
	@Autowired
	private BookService bookservice;

	/*
	 * @GetMapping public java.util.List<Book> listBooksAction(){ return
	 * bookservice.getAllBooks(); }
	 */ @GetMapping
	public ResponseEntity<java.util.List<Book>> listBooksAction() {
		return new ResponseEntity<java.util.List<Book>>(bookservice.getAllBooks(), HttpStatus.OK);
	}

//For searching based on URL
	@GetMapping("/{bcode}")
	public ResponseEntity<Book> getBookAction(@PathVariable("bcode") int bcode) {
		ResponseEntity<Book> resp = null;
		Book b = bookservice.getBookById(bcode);
		if (b == null)
			resp = new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<Book>(b, HttpStatus.OK);
		return resp;

	}

//multiple param receiving GetMapping(/{param1}/{param2}/{param3}	
//For deleting based on URL
	@DeleteMapping("/{bcode}")
	public ResponseEntity<Void> deleteBookAction(@PathVariable("bcode") int bcode) {
		ResponseEntity<Void> resp = null;

		boolean isDeleted = bookservice.deleteBookById(bcode);

		if (!isDeleted)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);

		return resp;

	}

	@PostMapping
	public ResponseEntity<Book> addBookAction(@RequestBody Book book) {
		ResponseEntity<Book> resp = null;
		book = bookservice.addBook(book);
		if (book != null)
			resp = new ResponseEntity<>(book, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return resp;
	}


	@PutMapping
	public ResponseEntity<Book> updateBookAction(@RequestBody Book book) {
		ResponseEntity<Book> resp = null;
		if (bookservice.getBookById(book.getBcode()) == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			book = bookservice.updateBook(book);
			if (book != null)
				resp = new ResponseEntity<>(book, HttpStatus.OK);
			else
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
