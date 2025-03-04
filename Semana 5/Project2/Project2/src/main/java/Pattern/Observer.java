package Pattern;

import spring.jpa.entity.Product;

public interface Observer {
    void update(Product product);
}