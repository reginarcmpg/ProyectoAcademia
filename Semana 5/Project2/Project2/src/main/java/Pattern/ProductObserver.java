package Pattern;

import spring.jpa.entity.Product;

public class ProductObserver implements Observer {

	@Override
    public void update(Product product) {
        System.out.println("New product: " + product.getMAKEUP());
    }
	
}