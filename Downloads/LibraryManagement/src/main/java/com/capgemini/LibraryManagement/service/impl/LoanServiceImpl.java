package com.capgemini.LibraryManagement.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.*;

import jakarta.transaction.Transactional;

public class LoanServiceImpl implements LoanService {

    private LoanDAO loanRepository;
    private MemberDAO memberRepository;
    private BookDAO bookRepository;

    @Override
    @Transactional
    public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {

        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            throw new RuntimeException("Member not found");
        }

        if (!member.getStatus().equals("ACTIVE")) {
            throw new RuntimeException("Member is blocked");
        }

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        if (book.getCopiesAvailable() <= 0) {
            throw new RuntimeException("No copies available");
        }

        Loan loan = new Loan();
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");
        loan.setMember(member);
        loan.setBook(book);

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);

        loanRepository.save(loan);
        bookRepository.save(book);

        return loan;
    }

    @Override
    @Transactional
    public Loan returnBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId).orElse(null);


        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus("RETURNED");

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);

        bookRepository.save(book);
        loanRepository.save(loan);

        return loan;
    }

    @Override
    public Loan getLoanById(Long loanId) {

        Loan loan = loanRepository.findById(loanId).orElse(null);

        return loan;
    }

    @Override
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepository.findByMember_MemberId(memberId);
    }
}