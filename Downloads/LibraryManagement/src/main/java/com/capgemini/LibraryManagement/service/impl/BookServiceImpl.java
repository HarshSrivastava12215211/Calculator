package com.capgemini.LibraryManagement.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.BookService;

import jakarta.transaction.Transactional;

public class BookServiceImpl implements BookService {
	
	private BookDAO bookdao;
	private CategoryDAO categorydao;
	private LibraryBranchDAO librarydao;
	private AuthorDAO authordao;

	@Override
	public Book addBook(Book book, Long categoryId, Long BranchId, List<Long> authorId) {
		
		Category cat = categorydao.findById(categoryId).orElse(null);
		
		LibraryBranch lib = librarydao.findById(BranchId).orElse(null);
		
		List<Author> authors = authordao.findAllById(authorId);

        book.setCategory(cat);
        book.setBranch(lib);
        book.setAuthor(new HashSet<>(authors));
        book.setCopiesAvailable(book.getCopiesTotal());
        book.setStatus("ACTIVE");

        return bookdao.save(book);
		
	}

	@Override
	@Transactional
	public Book getBookById(Long bookId) {
		Book book = bookdao.findById(bookId).orElse(null);
		
		return book;
	}

	@Override
	@Transactional
	public List<Book> getAllBook() {
		
		return bookdao.findAll();
		
	}

	@Override
	@Transactional
	public Book updateBook(Long bookId, Book updateBook) {
		Book update = getBookById(bookId);
		
		update.setTitle(updateBook.getTitle());
		update.setPublishYear(updateBook.getPublishYear());
		update.setCopiesAvailable(update.getCopiesAvailable());
		
		return bookdao.save(update);
	}

	@Override
	@Transactional
	public void deleteOrDisableBook(Long bookId) {
		Book book = getBookById(bookId);
        book.setStatus("INACTIVE");
        bookdao.save(book);
		
	}

}
