package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Book theBook) {
        System.out.println("Save Book");
        entityManager.persist(theBook); 
    }

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id); 
    }

    @Override
    public List<Book> findAll() {
    	TypedQuery<Book> theQuery = entityManager.createQuery("From Book", Book.class);
        return theQuery.getResultList(); 
    }

    @Override
    public List<Book> findByAuthor(String author) {
        // create query
        TypedQuery<Book> theQuery = entityManager.createQuery("From Book WHERE author=:authorName", Book.class);

        theQuery.setParameter("authorName", author);

        return theQuery.getResultList(); 
    }

    @Override
    @Transactional
    public void update(Book theBook) {
        entityManager.merge(theBook);
    }

    
}







