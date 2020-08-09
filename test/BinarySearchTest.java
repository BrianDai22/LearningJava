import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearchFindingNumberInTheMiddle() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 7);
        assertEquals(6, result);
    }

    @Test
    public void binarySearchFindNumberInTheBeginning() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 1);
        assertEquals(0, result);
    }

    @Test
    public void binarySearchFindNumberInTheEnd() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 9);
        assertEquals(8, result);
    }

    @Test
    public void binarySearchArrayIsEmpty() {
        int[] nums = new int[]{};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 5);
        assertEquals(-1, result);
    }

    @Test
    public void binarySearchOneItem() {
        int[] nums = new int[]{22};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 22);
        assertEquals(0, result);
    }

    @Test
    public void binarySearchAnswerIsNotHere() {
        int[] nums = new int[]{1,2,3,4,5,7,7,8,9};
        int result = BinarySearch.binarySearch(nums, 0,
                nums.length-1, 6);
        assertEquals(-1, result);
    }
}