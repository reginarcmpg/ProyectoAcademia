package spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.entity.Book;
                                               
public interface UserRepository extends JpaRepository<Book, Integer> {

   
}










