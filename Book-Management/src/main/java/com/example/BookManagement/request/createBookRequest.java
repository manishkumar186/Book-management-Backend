package com.example.BookManagement.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class createBookRequest {

    private String bookName;
    private String authorName;
}
