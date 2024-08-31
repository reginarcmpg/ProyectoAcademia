package builder;

import java.util.List;

public interface Builder {

	
	 void reset();
	 void setType(String type);
	 void setPrice(int price);
	 void setTopping(List <String> topping);
	 void setExtra(String extra);
	
	
	
}
