import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void reverseString() {
        String input = "abcd";
        String expectedOutput = "dcba";
        assertEquals(expectedOutput, Reverse.reverseString(input));
    }
}