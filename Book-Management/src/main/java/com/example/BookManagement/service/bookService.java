package com.example.BookManagement.service;

import com.example.BookManagement.entity.Book;
import com.example.BookManagement.exception.BookNotFound;
import com.example.BookManagement.repository.BookRepository;
import com.example.BookManagement.request.createBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookService {

    @Autowired
    BookRepository bookRepository;

    public Book createBookDetail(createBookRequest createbookrequest) {
        try{
            if(createbookrequest.getBookName().isEmpty() || createbookrequest.getAuthorName().isEmpty()){
                throw new BookNotFound("please enter valid detail");
            }
            Book book = new Book(createbookrequest);
            bookRepository.save(book);
            return book;
        }catch (Exception e){
            throw new BookNotFound(e.getMessage());
        }

    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public List<Book> startsWith(String bookName) {
        List<Book> bookList = bookRepository.findByBookNameStartsWith(bookName,Sort.by(Sort.Direction.ASC,"authorName"));

        try{
            if (bookList.isEmpty()) {
                throw new BookNotFound("Book not found");
            }
            return bookList;
        }
        catch(Exception e){
            throw new BookNotFound(e.getMessage());
        }
    }

    public Book getBookById(Integer id) {
        try{
            return bookRepository.findByBookId(id).get();
        }catch (Exception e){
            throw new BookNotFound("books not found");
        }
    }


}
