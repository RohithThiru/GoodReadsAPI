package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class BookService {
    HashMap<Integer, Book> hmap = new HashMap<>();
    int uniqueId = 3;

    public BookService() {
        // Initializing with sample books
        Book b1 = new Book(1, "Harry Potter", "HarryPotter.jpg");
        Book b2 = new Book(2, "Psychology of Money", "money.jpg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    // Get all books
    public ArrayList<Book> getBooks() {
        Collection<Book> bookCollection = hmap.values();
        return new ArrayList<>(bookCollection);
    }

    // Get a book by ID
    public Book getBookId(int id) {
        return hmap.get(id);
    }

    // Add a new book
    public Book addBook(Book book) {
        book.setId(uniqueId++); // Assign a unique ID to the book
        hmap.put(book.getId(), book);
        return book;
    }

    // Modify an existing book
    public Book modifyBook(int id, Book book) {
        Book existingBook = hmap.get(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }

        // Update fields if provided in the request
        if (book.getName() != null) {
            existingBook.setName(book.getName());
        }
        if (book.getImageUrl() != null) {
            existingBook.setImageUrl(book.getImageUrl());
        }

        return existingBook;
    }

    // Delete a book by ID
    public void deleteBook(int id) {
        Book book = hmap.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        hmap.remove(id); // Remove the book from the map
    }
}
