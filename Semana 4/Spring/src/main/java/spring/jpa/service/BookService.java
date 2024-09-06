package spring.jpa.service;

import java.util.List;

import spring.jpa.entity.Book;

public interface BookService {

	List<Book> findAll();//List Book

    Book findById(int theId);//Find book by ID

    Book save(Book theBook);//Add new book
    
    long countByGenre(String genre);//Book counter by genre
    
    boolean IsStock(int theId);// The boos is available or not
    
    void deleteById(int theId);//Delete book

}
