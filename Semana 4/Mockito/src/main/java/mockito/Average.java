package mockito;

public class Average {



    public String calculateAvr(float f1, float f2, float f3, float f4) {
    	
    	double avr = (f1 + f2 + f3 + f4) / 4;
    	
    	if(avr > 7) {
    		
    		return ("Grade: " + avr + "You Pass!");
    	}
    	else {
    		  return ("Grade: " + avr + "You Failed");
    	}
      
    }
}
