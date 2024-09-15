package Pattern;

import java.util.ArrayList;
import java.util.List;

import spring.jpa.entity.Product;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(Product product) {
        for (Observer o : observers) {
            o.update(product);
        }
    }
}