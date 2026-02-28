package com.capgemini.LibraryManagement.controller;


import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.*;
import com.capgemini.LibraryManagement.service.impl.*;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/api/v1/branches")
public class BranchController {

    private LibraryBranchDAO branchRepository;

    @PostMapping
    public LibraryBranch createBranch(@RequestBody LibraryBranch branch) {
        return branchRepository.save(branch);
    }

    @GetMapping("/{id}")
    public LibraryBranch getBranch(@PathVariable Long id) {

        LibraryBranch branch = branchRepository.findById(id).orElse(null);
        return branch;
    }

    @GetMapping
    public List<LibraryBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    @PutMapping("/{id}")
    public LibraryBranch updateBranch(@PathVariable Long id,@RequestBody LibraryBranch branch) {

        LibraryBranch existing = branchRepository.findById(id).orElse(null);

        existing.setName(branch.getName());
        existing.setLocation(branch.getLocation());
        existing.setContactNumber(branch.getContactNumber());

        return branchRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchRepository.deleteById(id);
    }
}