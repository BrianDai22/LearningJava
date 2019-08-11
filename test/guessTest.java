import org.junit.Test;

import static org.junit.Assert.*;

public class guessTest {

    @Test
    public void overlap() {
        String[] input1 = {"flies", "eatworms", null};
        String[] input2 = {"eatgrass", "isawesome", "makesmilk", "goesmoo",null,null};
        int expectedResult = 0;
        int result = guess.overlap(input1, input2);
        assertEquals(expectedResult, result);
    }
    @Test
    public void overlap2() {
        String[] input1 = {"eatgrass", "makesmilk", null};
        String[] input2 = {"eatgrass", "isawesome", "makesmilk", "goesmoo",null,null};
        int expectedResult = 2;
        int result = guess.overlap(input1, input2);
        assertEquals(expectedResult, result);
    }
}