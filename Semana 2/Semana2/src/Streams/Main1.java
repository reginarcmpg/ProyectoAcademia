package Streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {
       
//      Filtra los libros que fueron publicados después del año 2000.
//      Ordena estos libros por el año de publicación en orden descendente.
//      Mapea los libros filtrados a una nueva lista que contenga solo los títulos de los libros.
//      Limita el resultado a los primeros 5 títulos.
        
         List<Books> book = Arrays.asList(
                new Books("Guess How Much I Love You", "Sam McBratney", 1996, 50.65),
                new Books("To Kill a Mockingbird", "Harper Lee", 1960, 10.99),
                new Books("1984", "George Orwell", 1949, 8.99),
                new Books("Pride and Prejudice", "Jane Austen", 1813, 12.50),
                new Books("Gone with the Wind","Margaret Mitchell",1936,20.00),
                new Books("The Great Gatsby", "F. Scott Fitzgerald", 1925, 14.99),
                new Books("Moby-Dick","Herman Melville",1851,11.95),
                new Books("War and Peace","Leo Tolstoy",1869,15.00),
                new Books("The Catcher in the Rye","J.D. Salinger",1951,13.75),
                new Books("The Lord of the Rings","J.R.R. Tolkien",1954,25.99),
                new Books("Jane Eyre","Charlotte Brontë",1847,9.99),
                new Books("Animal Farm","George Orwell",1945,7.50),
                 new Books("Little Women","Louisa May Alcott",1868,11.25),
                new Books("Brave New World","Aldous Huxley",1932,10.50),
                new Books("The Hobbit","J.R.R. Tolkien",1937,18.00),
                new Books("The Chronicles of Narnia","C.S. Lewis",1950,22.50)
                
              
        );
        
         
         book.stream()
                 .filter(s -> s.getYear() > 1920)
                 .sorted(Comparator.comparing(Books::getYear))
                 //.peek(System.out::println.)
                 .map(Books::getTitle)
                 .limit(5)
                 
                 
		.forEach(S -> System.out.println(S));
         
    }
    
}
