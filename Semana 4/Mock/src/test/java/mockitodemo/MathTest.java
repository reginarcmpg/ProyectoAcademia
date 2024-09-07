package mockitodemo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class MathTest {

    @Mock
    private MathService mathServiceMock; //Creates a mock

    @InjectMocks
    private Calculator calculator; //Creates an instance of Calculator with the mock MathService injected.

    @Test
    public void testAddition() { //test addition
        // Mock behavior
        when(mathServiceMock.add(5, 3)).thenReturn(8);

        // Execute the method to be tested
        calculator.addition(5, 3);

        // Verify that the add method on MathService was called with the correct arguments
        verify(mathServiceMock).add(5, 3);
    }
    
    @Test
    public void testSubtraction() { //test subtraction
        when(mathServiceMock.subtract(5, 3)).thenReturn(2);
        calculator.Subtraction(5, 3);
        verify(mathServiceMock).subtract(5, 3);
    }
  
    @Test
    public void testMultiplication() { //test multiplication
        when(mathServiceMock.multiply(5, 3)).thenReturn(15);
        calculator.Multiplication(5, 3);
        verify(mathServiceMock).multiply(5, 3);
    }
    
    @Test
    public void testDivision() { //test division
        when(mathServiceMock.divide(5, 3)).thenReturn(1);
        calculator.Division(5, 3);
        verify(mathServiceMock).divide(5, 3);
    }
}
