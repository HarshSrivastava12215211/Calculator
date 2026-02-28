package com.capgemini.LibraryManagement.service;

import java.time.LocalDate;
import java.util.*;
import com.capgemini.LibraryManagement.dto.*;

public interface LoanService {
	
	Loan issueBook(Long memberId, Long BookId, LocalDate dueDate);
	
	Loan returnBook(Long loanId);
	
	Loan getLoanById(Long loanId);
	
	List<Loan> getAllLoan();
	
	List<Loan> getLoansByMember(Long memberId);

}
