package spring.jpa.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Pattern.ProductObserver;
import Pattern.ProductSubject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import spring.jpa.dao.ProductRepository;
import spring.jpa.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager entityManager;
    private ProductRepository productrepository;
    private final ProductSubject productSubject = new ProductSubject();

    @Autowired
    public ProductServiceImpl(ProductRepository theproductrepository) {
        productrepository = theproductrepository;
        productSubject.subscribe(new ProductObserver());// observer
    }

    @Override
    public List<Product> findAll() { //find all product
        return productrepository.findAll();
    }

    @Override
   public Product findById(int theId) { //find by ID
    Optional<Product> result = productrepository.findById(theId);
    return result.orElse(null);
    }
   
    @Override
    public boolean IsStock(int bookId) { //Checks if a product is in stock
    	Product product = entityManager.find(Product.class, bookId);
    	return product != null && product.getSTOCK() > 0 ;
   }
    
    @Override
    public List<Product> PriceWithDiscount(double discountPercentage){ //Discount with lambas
    	 List<Product> products =  findAll();
    	 return products.stream()
    			 .map(product -> {
    				 if(product.getPRICE() >15){
    					 product.setPRICE(product.getPRICE() - (product.getPRICE() * (discountPercentage / 100)));
    				 } 	return product; 
    			 }) 
    			 .collect(Collectors.toList()); 
    }
    
    @Transactional
    @Override
    public Product save(Product theproduct) { //Add new product or update of one
    	 Product savedProduct = productrepository.save(theproduct);
         productSubject.productUp(savedProduct); //notify
         return savedProduct;
    }
 
    @Transactional
    @Override
    public void deleteById(int theId) {//Delete book 
    	productrepository.deleteById(theId);
    }

	@Override
	public List<Product> filterProducts(Predicate<Product> predicate) {//filter price
		return productrepository.findAll()
                .stream()
                .filter(predicate)
                .toList();
	}



}






