package mockitodemo;

public class MathServiceImp implements MathService {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
        return a / b;
	}
}
