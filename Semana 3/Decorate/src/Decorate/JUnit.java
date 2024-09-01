package Decorate;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainOutput() {

        Main.main(new String[]{});


        String expectedOutput = 
            "Facial Treatment Service Price: 500" + System.lineSeparator() +
            "Client: Monica" + System.lineSeparator() +
            "Extra: Essential Oils" + System.lineSeparator() +
            "Price: 135" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "Total cost for Monica: 635" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "Swedish Massage Service Price: 450" + System.lineSeparator() +
            "Cliente: Regina" + System.lineSeparator() +
            "Extra: Essential Oils" + System.lineSeparator() +
            "Price: 50" + System.lineSeparator() +
            "" + System.lineSeparator() +
            "Total cost for Regina: 500" + System.lineSeparator();
        

        assertEquals(expectedOutput, outContent.toString());
    }
}
