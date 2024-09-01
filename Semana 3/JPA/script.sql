CREATE DATABASE IF NOT EXISTS Books;

USE Books;

DROP TABLE IF EXISTS Book;

CREATE TABLE `books` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Title` varchar(64) DEFAULT NULL,
  `Author` varchar(64) DEFAULT NULL,
  `Category` varchar(64) DEFAULT NULL,
  `Year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `books` (`Title`, `Author`, `Category`, `Year`) VALUES  -- Quité `id` de la instrucción `INSERT`
('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 1960),
('1984', 'George Orwell', 'Dystopian', 1949),
('One Hundred Years of Solitude', 'Gabriel García Márquez', 'Magical Realism', 1967),
('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 1925),
('War and Peace', 'Leo Tolstoy', 'Historical Fiction', 1869),
('Pride and Prejudice', 'Jane Austen', 'Romance', 1813),
('The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 1951),
('Crime and Punishment', 'Fyodor Dostoevsky', 'Psychological Fiction', 1866),
('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 1937),
('Don Quixote', 'Miguel de Cervantes', 'Adventure', 1605);
select * from books;
DROP DATABASE Books;