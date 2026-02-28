package com.capgemini.LibraryManagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Book {
	@Id
	private long bookId;
	private String title;
	private String isbn;
	private int publishYear;
	private int copiesTotal;
	private int copiesAvailable;
	private String status;
	
	@ManyToMany
	@JoinTable(name = "book_authors" ,joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> author;
	
	@ManyToMany
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private LibraryBranch branch;
	
	@OneToMany(mappedBy = "book")
	private List<Loan> loan;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getCopiesTotal() {
		return copiesTotal;
	}

	public void setCopiesTotal(int copiesTotal) {
		this.copiesTotal = copiesTotal;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Author> getAuthor() {
		return author;
	}

	public void setAuthor(Set<Author> author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", publishYear=" + publishYear
				+ ", copiesTotal=" + copiesTotal + ", copiesAvailable=" + copiesAvailable + ", status=" + status
				+ ", author=" + author + ", category=" + category + ", branch=" + branch + ", loan=" + loan + "]";
	}
	
	
}
