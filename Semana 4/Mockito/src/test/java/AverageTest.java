import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mockito.Average;
import mockito.AverageCloud;

public class AverageTest {

    private Average calculator;

    @Mock
    private AverageCloud cloud;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculator = new Average(cloud);
    }

    @Test
    public void testCalculateAvr_Passed() {
        when(cloud.Avr(6.5f, 7.0f, 8.5f, 9.0f))
            .thenReturn("Passed: The average is 7.00, which is above or equal to 7.");

        String result = calculator.calculateAvr(6.5f, 7.0f, 8.5f, 9.0f);
        assertEquals("Passed: The average is 7.00, which is above or equal to 7.", result);
    }

    @Test
    public void testCalculateAvr_Failed() {
        when(cloud.Avr(5.0f, 6.0f, 6.0f, 5.0f))
            .thenReturn("Failed: The average is 5.50, which is below 7.");

        String result = calculator.calculateAvr(5.0f, 6.0f, 6.0f, 5.0f);
        assertEquals("Failed: The average is 5.50, which is below 7.", result);
    }
}

