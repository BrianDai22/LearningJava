package leetcode_queue_stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {

    @Test
    public void numIslands() {
        char[][] grid = new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        };
        int result = NumberOfIslandsTemplate.numIslands(grid);
        Assert.assertEquals(1, result);
    }

    @Test
    public void numIslands2() {
        char[][] grid = new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        };
        int result = NumberOfIslandsTemplate.numIslands(grid);
        Assert.assertEquals(3, result);
    }
}