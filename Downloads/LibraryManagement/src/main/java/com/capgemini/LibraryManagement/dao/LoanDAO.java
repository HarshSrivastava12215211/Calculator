package com.capgemini.LibraryManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.capgemini.LibraryManagement.dto.Loan;

public interface LoanDAO extends JpaRepository<Loan, Long> {
	
	List<Loan> findByMember_MemberId( long memberId);
	List<Loan> findByBook_BookId(long bookId);
	List<Loan> findByStatus(String status);

}
