package spring.jpa.rest;

import spring.jpa.entity.Book;
import spring.jpa.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService theBookService) {
    	bookService = theBookService;
    }

    @GetMapping("/books")// Get the list of all books
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}") //Get the book by id
    public Book getBook(@PathVariable int bookId) {
        Book theBook = bookService.findById(bookId);
        if (theBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }
        return theBook;
    }
    
    @GetMapping("/books/genre/{genre}") //Number of books by genre
    public long countBooksByGenre(@PathVariable String genre) {
        return bookService.countByGenre(genre);
    }
    
    @GetMapping("/books/{bookId}/stock")//Books available
    public String IsStock(@PathVariable int bookId) {
    	boolean inStock = bookService.IsStock(bookId);
    		String message = inStock ? "Book available" : "Book not available";
    		return message ;
    } 
    
    @GetMapping("/books/{discountPercentage}/price")//Books available
    public List <String> Discount(@PathVariable double discountPercentage) {
    	  List<Book> booksWithDiscount = bookService.PriceWithDiscount(discountPercentage);
    	  return booksWithDiscount.stream()
                  .map(book -> "Title: " + book.getTitle() + ", Price with discount: " + book.getPrice())
                  .collect(Collectors.toList());
    } 
 
    @PostMapping("/books") //add new post
    public Book addBook(@RequestBody Book theBook) {
        theBook.setId(0);
        return bookService.save(theBook);
    }
    
    @PutMapping("/books") //update a book
    public Book updateBook(@RequestBody Book theBook) {
        return bookService.save(theBook);
    }
    
    @DeleteMapping("/books/{bookId}")//delete books
    public String deleteBook(@PathVariable int bookId) {
        Book tempBook = bookService.findById(bookId);
        if (tempBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted book id - " + bookId;
    }
    
}


