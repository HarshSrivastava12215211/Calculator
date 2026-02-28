package com.capgemini.LibraryManagement.controller;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;

@RestControllerAdvice
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryDAO categoryRepository;

    @PostMapping
    public Category create(@RequestParam Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {

        Category existing = categoryRepository.findById(id).orElse(null);

        if (existing == null) {
            throw new RuntimeException("Category not found");
        }

        existing.setName(category.getName());
        existing.setDescription(category.getDescription());

        return categoryRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}