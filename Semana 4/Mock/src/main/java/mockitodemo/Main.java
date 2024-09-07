package mockitodemo;

public class Main {

	public static void main(String[] args) {
		MathService mathservice = new MathServiceImp();
		Calculator calculator = new Calculator(mathservice);

		calculator.addition(5, 8);
		calculator.Subtraction(10, 4);        
        calculator.Multiplication(7, 6);      
        calculator.Division(20, 4);           

	}

}
