package mockitodemo;

public class Calculator {

	private MathService mathService;

	public Calculator(MathService mathService) {
		this.mathService = mathService;
	}
	
	public void addition(int a, int b) {
		int result = mathService.add(a, b);
		System.out.println("Addition: " + a + " + " + b + " = " + result);
	}
	
	public void Subtraction(int a, int b) {
		int result = mathService.subtract(a, b);
		System.out.println("Subtraction: " + a + " + " + b + " = " + result);
	}
	
	public void Multiplication(int a, int b) {
		int result = mathService.multiply(a, b);
		System.out.println("Multiplication: " + a + " + " + b + " = " + result);
	}
	
	public void Division(int a, int b) {
            double result = mathService.divide(a, b);
            System.out.println("Division: " + a + " / " + b + " = " + result);
        
    }
}


