package Observer;

public class Lip implements Observer{
	
	LipBrand brand; //class atribute

	public Lip(LipBrand brand) {
		this.brand = brand;
	}
	
	
	void ShowLip() {//print the brand of the lip
		System.out.println(brand);
	}


	@Override
	public void update() {
		 ShowLip();//print the brand of the base
		
	}
	

}
