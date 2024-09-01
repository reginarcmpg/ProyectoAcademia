package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	List<Observer> observers = new ArrayList<>();
	
	void subscription(Observer o) {
		observers.add(o); //subscribe to makeup
	}
	
	void Cancel(Observer o) {
		observers.remove(o);
		}
		
	
	public void Notify() { //will send the notification
		for(Observer o: observers)
			o.update();
	}
		
	
	
	
}
