package com.example.demo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {

    BookService bookService = new BookService();

    // Get all books
    @GetMapping("/books")
    public ArrayList<Book> books() {
        return bookService.getBooks();
    }

    // Get a book by ID
    @GetMapping("/book/{id}")
    public Book book(@PathVariable("id") int id) {
        Book book = bookService.getBookId(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        return book;
    }

    // Add a new book
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Modify an existing book
    @PutMapping("/book/{id}")
    public Book modifyBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.modifyBook(id, book);
    }

    // Delete a book by ID
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }
}
