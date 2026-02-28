package com.capgemini.LibraryManagement.service;
import java.util.*;
import com.capgemini.LibraryManagement.dto.*;
public interface BookService {
	
	Book addBook(Book book, Long categoryId, Long BranchId, List<Long> authorsId);
	
	Book getBookById(Long bookId);
	
	List<Book> getAllBook();
	
	Book updateBook(Long bookId, Book updateBook);
	
	void deleteOrDisableBook(Long bookId);

}
