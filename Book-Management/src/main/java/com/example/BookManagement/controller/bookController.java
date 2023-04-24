package com.example.BookManagement.controller;

import com.example.BookManagement.entity.Book;
import com.example.BookManagement.request.createBookRequest;
import com.example.BookManagement.response.bookResponse;
import com.example.BookManagement.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class bookController {

    @Autowired
    bookService bookservice;

    @PostMapping("/addBook")
    public bookResponse createBook(@RequestBody createBookRequest createbookrequest){
        Book book = bookservice.createBookDetail(createbookrequest);
        return new bookResponse(book);
    }

    @GetMapping("/allBook")
    public List<bookResponse>getBook(){
        List<Book> bookList = bookservice.getAllBook();

        List<bookResponse> bookResponseList = new ArrayList<bookResponse>();
        bookList.stream().forEach(book->{
            bookResponseList.add(new bookResponse(book));
        });

        return bookResponseList;
    }

    @GetMapping("startsWith/{bookName}")
    public List<bookResponse> startsWith(@PathVariable String bookName){
        List<Book> bookList = bookservice.startsWith(bookName);

        List<bookResponse> bookResponseList = new ArrayList<bookResponse>();
        bookList.stream().forEach(book->{
            bookResponseList.add(new bookResponse(book));
        });
        return bookResponseList;
    }

    @GetMapping("getById/{id}")
    public Book getById(@PathVariable Integer id){
        return bookservice.getBookById(id);

    }





}
