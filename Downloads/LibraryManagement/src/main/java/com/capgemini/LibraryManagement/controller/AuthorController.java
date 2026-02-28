package com.capgemini.LibraryManagement.controller;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.*;
import com.capgemini.LibraryManagement.service.impl.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private  AuthorDAO authorRepository;

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {

        Author author = authorRepository.findById(id).orElse(null);
        return author;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id,
                               @RequestBody Author author) {

        Author existing = authorRepository.findById(id).orElse(null);

        existing.setName(author.getName());
        existing.setBiography(author.getBiography());

        return authorRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }
}