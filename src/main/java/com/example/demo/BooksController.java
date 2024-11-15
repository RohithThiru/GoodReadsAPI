package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import com.example.demo.BookService;
import com.example.demo.Book;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BooksController {

    BookService bookService = new BookService();
    @GetMapping("/books")
    public ArrayList<Book> books(){
        return  bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book book(@PathVariable("id")  int id){
        Book book = bookService.getBookId(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }
}
