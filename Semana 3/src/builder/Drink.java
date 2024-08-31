package builder;

import java.util.List;

public class Drink {

	private String type;
	private int price;
	private List<String> topping;
	private String extra;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<String> getTopping() {
		return topping;
	}
	public void setTopping(List<String> topping) {
		this.topping = topping;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	@Override
	public String toString() {
		return "Drink [type=" + type + ", price=" + price + ", topping=" + topping + ", extra=" + extra + "]";
	}
	
	

}


