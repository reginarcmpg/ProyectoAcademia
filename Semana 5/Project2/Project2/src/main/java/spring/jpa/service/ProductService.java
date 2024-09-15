package spring.jpa.service;

import java.util.List;
import java.util.function.Predicate;

import spring.jpa.entity.Product;

public interface ProductService {

	List<Product> findAll();//List product

	Product findById(int theId);//Find product by ID

	Product save(Product theBook);//Add new product
    
    List<Product> filterProducts(Predicate<Product> predicate);//filter product by price
    
    boolean IsStock(int theId);// The product is available or not
    
    void deleteById(int theId);//Delete product
    
    List<Product> PriceWithDiscount(double discountPercentage); //discount
    

}
