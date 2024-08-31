package Observer;

public class Lip implements Observer{
	
	LipBrand brand;

	public Lip(LipBrand brand) {
		this.brand = brand;
	}
	
	
	void ShowLip() {
		System.out.println(brand);
	}


	@Override
	public void update() {
		 ShowLip();
		
	}
	

}
