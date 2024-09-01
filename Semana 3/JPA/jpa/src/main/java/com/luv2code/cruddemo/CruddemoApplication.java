package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.BookDAO;
import com.luv2code.cruddemo.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookDAO bookDAO) {

        return runner -> {
            createBook(bookDAO);

            createMultipleBooks(bookDAO);

            readBook(bookDAO);

            queryForBooks(bookDAO);

            queryForBooksByAuthor(bookDAO);

            updateBook(bookDAO);

      
        };
    }

    private void updateBook(BookDAO bookDAO) {    
        int bookId = 12; 
        System.out.println("Getting book with id: " + bookId);
        Book myBook = bookDAO.findById(bookId);


        System.out.println("Updating book ");
        myBook.setTitle("Updated Title");
        bookDAO.update(myBook);
        System.out.println("Updated book: " + myBook);
    }

    private void queryForBooksByAuthor(BookDAO bookDAO) {

        List<Book> theBooks = bookDAO.findByAuthor("Fyodor Dostoevsky");

        for (Book tempBook : theBooks) {
            System.out.println(tempBook);
        }
    }

    private void queryForBooks(BookDAO bookDAO) {

        List<Book> theBooks = bookDAO.findAll();

        for (Book tempBook : theBooks) {
            System.out.println(tempBook);
        }
    }

    private void readBook(BookDAO bookDAO) {

        System.out.println("Creating new book object");
        Book tempBook = new Book("New Book", "Author Name", "Category", 2024);

        System.out.println("Saving the book");
        bookDAO.save(tempBook);

        int theId = tempBook.getId();
        System.out.println("Saved book. Generated id: " + theId);

        System.out.println("Retrieving book with id: " + theId);
        Book myBook = bookDAO.findById(theId);

        System.out.println("Found the book: " + myBook);
    }

    private void createMultipleBooks(BookDAO bookDAO) {

        System.out.println("Creating 10 book objects");
        Book tempBook1 = new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951);
        Book tempBook2 = new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932);
        Book tempBook3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925);
        Book tempBook4 = new Book("Moby-Dick", "Herman Melville", "Adventure", 1851);
        Book tempBook5 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954);
        Book tempBook6 = new Book("Don Quixote", "Miguel de Cervantes", "Adventure", 1605);
        Book tempBook7 = new Book("One Hundred Years of Solitude", "Gabriel García Márquez", "Magical Realism", 1967);
        Book tempBook8 = new Book("War and Peace", "Leo Tolstoy", "Historical Fiction", 1869);
        Book tempBook9 = new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813);
        Book tempBook10 = new Book("Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction", 1866);

  
        System.out.println("Saving the books");
        bookDAO.save(tempBook1);
        bookDAO.save(tempBook2);
        bookDAO.save(tempBook3);
        bookDAO.save(tempBook4);
        bookDAO.save(tempBook5);
        bookDAO.save(tempBook6);
        bookDAO.save(tempBook7);
        bookDAO.save(tempBook8);
        bookDAO.save(tempBook9);
        bookDAO.save(tempBook10);
    }

    private void createBook(BookDAO bookDAO) {

        System.out.println("Creating new book object ...");
        Book tempBook = new Book("Initial Book", "Initial Author", "Category", 2023);
        System.out.println("Saving the book");
        bookDAO.save(tempBook);
        System.out.println("Saved book. Generated id: " + tempBook.getId());
    }
}



