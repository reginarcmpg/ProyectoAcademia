package Pattern;

import spring.jpa.entity.Product;

public class ProductSubject extends Subject {

    public void productUp(Product product) {
        notifyObservers(product);
    }
}