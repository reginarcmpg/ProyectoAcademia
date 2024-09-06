package spring.jpa.service;

import spring.jpa.dao.BookDAO;
import spring.jpa.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookdao;

    @Autowired
    public BookServiceImpl(BookDAO theBookDAO) {
    	bookdao = theBookDAO;
    }

    
    @Override
    public List<Book> findAll() {
        return bookdao.findAll();
    }

    
    @Override
    public Book findById(int theId) {
        return bookdao.findById(theId);
    }

    
    @Override
    public long countByGenre(String genre) {
        return bookdao.countByGenre(genre);
    }
    
    
    @Override
    public boolean IsStock(int bookId) {
        return bookdao.IsStock(bookId);
    }
    
    
    @Transactional
    @Override
    public Book save(Book theBook) {
        return bookdao.save(theBook);
    }

    
    @Transactional
    @Override
    public void deleteById(int theId) {
    	bookdao.deleteById(theId);
    }
}






