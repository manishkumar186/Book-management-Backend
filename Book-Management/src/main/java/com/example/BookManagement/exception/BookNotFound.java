package com.example.BookManagement.exception;

public class BookNotFound extends RuntimeException {
    public BookNotFound(String msg) {
        super(msg);
    }
}
