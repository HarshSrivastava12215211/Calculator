package com.capgemini.LibraryManagement.controller;

import com.capgemini.LibraryManagement.dao.*;
import com.capgemini.LibraryManagement.service.*;
import com.capgemini.LibraryManagement.dto.*;
import com.capgemini.LibraryManagement.service.impl.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book,
                           @RequestParam Long categoryId,
                           @RequestParam Long branchId,
                           @RequestParam List<Long> authorIds) {

        return bookService.addBook(book, categoryId, branchId, authorIds);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteOrDisableBook(id);
    }
}