package com.capgemini.LibraryManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.LibraryManagement.dto.Author;

public interface AuthorDAO extends JpaRepository<Author, Long> {

	
}
