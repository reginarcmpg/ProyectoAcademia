package Observer;

public class Base implements Observer {
	BaseBrand brand;

	public Base(BaseBrand brand) {
		this.brand = brand;
	}
	
	
	void ShowBase() {
		System.out.println(brand);
	}


	@Override
	public void update() {
		ShowBase();
		
	}
}
