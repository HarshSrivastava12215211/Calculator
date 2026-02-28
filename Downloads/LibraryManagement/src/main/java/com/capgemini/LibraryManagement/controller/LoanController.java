package com.capgemini.LibraryManagement.controller;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.*;
import com.capgemini.LibraryManagement.service.impl.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LoanController {

    private  LoanService loanService;

    @PostMapping("/loans/issue")
    public Loan issueBook(@RequestParam Long memberId,
                          @RequestParam Long bookId,
                          @RequestParam String dueDate) {

        return loanService.issueBook(memberId, bookId, LocalDate.parse(dueDate));
    }

    @PutMapping("/loans/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId) {
        return loanService.returnBook(loanId);
    }

    @GetMapping("/loans/{loanId}")
    public Loan getLoan(@PathVariable Long loanId) {
        return loanService.getLoanById(loanId);
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoan();
    }

    @GetMapping("/members/{memberId}/loans")
    public List<Loan> getMemberLoans(@PathVariable Long memberId) {
        return loanService.getLoansByMember(memberId);
    }
}
