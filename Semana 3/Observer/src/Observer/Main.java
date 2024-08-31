package Observer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner number = new Scanner(System.in); 
	    System.out.println("ENTERTHE NUMBER OF SUBSCRIPTION THAT YOU WISH");
	    System.out.println("1.- LIP");
	    System.out.println("2.- BASE");

	    int num = number.nextInt();
		
		switch(num) {
		  case 1:
				Observer lip1 = new Lip(LipBrand.CHANEL);
				Makeup subs1 = new Makeup();
				subs1.subscription(lip1);
				System.out.println("The lipstick that just arrived is: "); 
				subs1.Sub();
	
				
		    break;
		    
		  case 2:
			  Observer Base2 = new Base(BaseBrand.FOUNDATION);
				
				Makeup subs2 = new Makeup();
				subs2.subscription(Base2);
				System.out.println("The Base that just arrived is: "); 
				subs2.Sub();
		    break;
		    
		  
		}

		
		
	}

}
