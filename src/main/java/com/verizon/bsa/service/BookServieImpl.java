package com.verizon.bsa.service;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.bsa.dao.BookDao;
import com.verizon.bsa.model.Book;

@Service
public class BookServieImpl implements BookService {
	
	@Autowired
	private BookDao bookdao;
	
	@Override
	public Book addBook(Book book) {
		return bookdao.addBook(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookdao.updateBook(book);
	}

	@Override
	public Book getBookById(int bcode) {
		return bookdao.getBookById(bcode);
	}

	@Override
	public boolean deleteBookById(int bcode) {
		return bookdao.deleteBookById(bcode);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookdao.getAllBooks();
	}
	
}
