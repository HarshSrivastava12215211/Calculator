package com.capgemini.LibraryManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.LibraryManagement.dto.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {

}
