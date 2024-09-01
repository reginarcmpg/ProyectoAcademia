package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Book;

import java.util.List;

public interface BookDAO {

    void save(Book theBook);
    Book findById(Integer id);
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    void update(Book theBook);

}
