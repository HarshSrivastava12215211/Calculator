package com.capgemini.LibraryManagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;
@Entity
public class LibraryBranch {
	
	@Id
	private int branchId;
	private String name;
	private String location;
	private String ContactNumber;
	
	@OneToMany(mappedBy = "branch")
	private List<Book> books;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "LibraryBranch [branchId=" + branchId + ", name=" + name + ", location=" + location + ", ContactNumber="
				+ ContactNumber + ", books=" + books + "]";
	}
	

}
