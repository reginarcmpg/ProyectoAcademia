package builder;

import java.util.ArrayList;
import java.util.List;

public class Director {
	public void Coffe(Builder builder) { //create coffe
			builder.reset();
	        builder.setType("LATTE");
	        builder.setPrice(65);
	        List<String> toppings = new ArrayList<>();
	        toppings.add("Milk");
	        toppings.add("Sugar");
	        builder.setTopping(toppings);
	        builder.setExtra("chocolate");
    }

  
    public void Te(Builder builder) { //create te
    		builder.reset();
	        builder.setType("BLACK");
	        builder.setPrice(45);
	        List<String> toppings = new ArrayList<>();
	        toppings.add("sugar");
	        toppings.add("Lactosed milk");
	        builder.setTopping(toppings);
	        builder.setExtra("- -");
    }
}
