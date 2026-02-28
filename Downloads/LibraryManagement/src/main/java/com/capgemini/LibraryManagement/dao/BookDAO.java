package com.capgemini.LibraryManagement.dao;
import com.capgemini.LibraryManagement.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface BookDAO extends JpaRepository<Book, Long> {

	Optional<Book> findByIsbn(String isbn);
	
	List<Book> findByStatus(String status);
	
	List<Book> findByCategory_CategoryId(Long CategoryId);
	
	List<Book> findByBranch_BranchId(Long branchId);
}
