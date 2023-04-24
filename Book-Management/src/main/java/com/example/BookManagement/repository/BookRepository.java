package com.example.BookManagement.repository;

import com.example.BookManagement.entity.Book;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    List<Book> findByBookNameStartsWith(String authorName, Sort name);

    Optional<Book> findByBookId(Integer id);
}
