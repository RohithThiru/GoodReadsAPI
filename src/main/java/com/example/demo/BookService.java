package com.example.demo;

import java.util.*;

public class BookService{
    HashMap<Integer, Book> hmap = new HashMap<>();

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

}
