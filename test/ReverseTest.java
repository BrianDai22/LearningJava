import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void reverseString() {
        String input = "abcd";
        String expectedOutput = "dcba";
        assertEquals(expectedOutput, Reverse.reverseString(input));
    }

    @Test
    public void reverseSentence() {
        String input = "The London Bridge is falling down";
        String expectedOutput = "down falling is Bridge London The";
        assertEquals(expectedOutput, Reverse.reverseSentence(input));
    }

    @Test
    public void reverseSentenceWithPeriod() {
        String input = "The London Bridge is falling down.";
        String expectedOutput = "down falling is Bridge London The.";
        assertEquals(expectedOutput, Reverse.reverseSentence(input));
    }
}