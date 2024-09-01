package Observer;

public class Base implements Observer {
	BaseBrand brand; //class atribute

	public Base(BaseBrand brand) {
		this.brand = brand;
	}
	
	
	void ShowBase() { //print the brand of the base
		System.out.println(brand);
	}


	@Override
	public void update() {
		ShowBase();  //sends the method to the observer
		
	}
}
