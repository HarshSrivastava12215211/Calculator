package com.capgemini.LibraryManagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.*;
@Entity
public class Author {

	@Id
	private int authorId;
	private String name;
	private String biography;
	
	@ManyToMany(mappedBy = "author")
	private Set<Book> book;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", biography=" + biography + ", book=" + book + "]";
	}
	
	
}
