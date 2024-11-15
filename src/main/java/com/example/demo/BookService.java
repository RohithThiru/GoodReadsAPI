package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class BookService{
    HashMap<Integer, Book> hmap = new HashMap<>();
    int uniqueId = 3;
    public BookService() {
        Book b1 = new Book(1, "Harry Potter", "HarryPotter.jpg");
        Book b2 = new Book(2, "Psychology of Money", "money.jpg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    public  ArrayList<Book> getBooks() {
        Collection<Book> bookCollection =  hmap.values();
        ArrayList<Book> books = new ArrayList<>(bookCollection);
        return books;
    }

    public Book getBookId(int id){
        Book book = hmap.get(id);
        return book;
    }

    public Book addBook(Book book) {
        book.setId(uniqueId++);
        hmap.put(uniqueId, book);
        return book;
    }

    public Book modifyBook(int id, Book book) {
        Book existingBook = hmap.get(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (book.getName() != null){
            existingBook.setName(book.getName());
        }
        if (book.getImageUrl() != null){
            existingBook.setImageUrl(book.getImageUrl());
        }
        return existingBook;
    }

    public void deleteBook(int id) {
        Book book = hmap.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            hmap.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
