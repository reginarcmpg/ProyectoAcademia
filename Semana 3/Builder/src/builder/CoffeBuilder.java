package builder;

import java.util.List;

public class CoffeBuilder implements Builder {
	
	private Drink coffebuilder;

	@Override
	public void reset() {
		this.coffebuilder = new Drink();
		
	}

	@Override
	public void setType(String type) {
		coffebuilder.setType(type);
		
	}

	@Override
	public void setPrice(int price) {
		coffebuilder.setPrice(price);
		
	}

	@Override
	public void setTopping(List <String> topping) {
		coffebuilder.setTopping(topping);
		
	}

	@Override
	public void setExtra(String extra) {
		coffebuilder.setExtra(extra);
		
	}

	
	public Drink getResult() {
		return this.coffebuilder;
		
	}
}
