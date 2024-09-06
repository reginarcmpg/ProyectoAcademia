package spring.jpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import spring.jpa.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

 
    private EntityManager entityManager;

    public BookDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() { // Retrieves all books and sorts them by the published year
        TypedQuery<Book> theQuery = entityManager.createQuery("from Book", Book.class); 
        List<Book> books = theQuery.getResultList();
        Collections.sort(books, Comparator.comparing(Book::getPublished)); 
        return books;
    }

    @Override
    public Book findById(int theId) { //Find book by ID
        Book theBook = entityManager.find(Book.class, theId);
        return theBook;
    }
        
    @Override
    public long countByGenre(String genre) { //Uses JPQL to count books by genre
        String jpql = "SELECT COUNT(b) FROM Book b WHERE b.genre = :genre";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter("genre", genre);
        return query.getSingleResult();
    }
    
    @Override
    public boolean IsStock(int bookId) {//Checks if a book is in stock
    	Book book = entityManager.find(Book.class, bookId);
    	return book != null && book.getStock() > 0 ;
    }
    
    @Override
    public Book save(Book theEmployee) {//Add new book or update of one
        Book dbBook = entityManager.merge(theEmployee);
        return dbBook;
    }

    @Override
    public void deleteById(int theId) {//Delete book 
        Book theBook = entityManager.find(Book.class, theId);
        entityManager.remove(theBook);
    }
}











