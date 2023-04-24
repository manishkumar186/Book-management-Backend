package com.example.BookManagement.entity;

import com.example.BookManagement.request.createBookRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String authorName;

    public Book(createBookRequest createbookrequest){
        this.bookName = createbookrequest.getBookName();
        this.authorName = createbookrequest.getAuthorName();
    }

}
