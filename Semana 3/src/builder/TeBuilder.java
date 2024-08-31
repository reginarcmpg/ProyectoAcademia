package builder;

import java.util.List;

public class TeBuilder implements Builder {
	
	private Drink Te;

	@Override
	public void reset() {
		this.Te = new Drink();
		
	}

	@Override
	public void setType(String type) {
		Te.setType(type);
		
	}

	@Override
	public void setPrice(int price) {
		Te.setPrice(price);
		
	}

	@Override
	public void setTopping(List <String> topping) {
		Te.setTopping(topping);
		
	}

	@Override
	public void setExtra(String extra) {
		Te.setExtra(extra);
		
	}

	
	public Drink getResult() {
		return this.Te;
		
	}
}
