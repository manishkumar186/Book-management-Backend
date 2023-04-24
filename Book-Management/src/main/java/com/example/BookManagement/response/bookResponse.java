package com.example.BookManagement.response;

import com.example.BookManagement.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class bookResponse {

    private int bookId;
    private String bookName;
    private String authorName;

    public bookResponse(Book book){
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.authorName = book.getAuthorName();
    }
}
