package com.capgemini.LibraryManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.LibraryManagement.dto.LibraryBranch;

public interface LibraryBranchDAO extends JpaRepository<LibraryBranch, Long> {

}
