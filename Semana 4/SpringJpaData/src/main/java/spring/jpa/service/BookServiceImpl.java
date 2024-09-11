package spring.jpa.service;

import spring.jpa.dao.BookRepository;
import spring.jpa.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

	@PersistenceContext
	private EntityManager entityManager;
    private BookRepository bookrepository;

    @Autowired
  
    public BookServiceImpl(BookRepository thebookrepository) {
    	bookrepository = thebookrepository;
 	}


    @Override
    public List<Book> findAll() { //find all books
        return bookrepository.findAll();
    }

 

@Override
   public Book findById(int theId) { //find by ID
    Optional<Book> result = bookrepository.findById(theId);
    return result.orElse(null);
  }

    
   @Override
   public long countByGenre(String genre) { //count books by genre
	   String jpql = "SELECT COUNT(b) FROM Book b WHERE b.genre = :genre";
	   TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
	   query.setParameter("genre", genre);
	   return query.getSingleResult();
    }
    
   
    
    @Override
    public boolean IsStock(int bookId) { //Checks if a book is in stock
    	Book book = entityManager.find(Book.class, bookId);
    	return book != null && book.getStock() > 0 ;
   }
    
    
    @Transactional
    @Override
    public Book save(Book theBook) { //Add new book or update of one
        return bookrepository.save(theBook);
    }

    
    @Transactional
    @Override
    public void deleteById(int theId) {//Delete book 
    	bookrepository.deleteById(theId);
    }



}






