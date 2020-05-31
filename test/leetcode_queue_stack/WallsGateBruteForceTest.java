package leetcode_queue_stack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallsGateBruteForceTest {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    @Test
    public void wallsAndGates() {
        int[][] rooms = new int[][]{
                {EMPTY, WALL, GATE, EMPTY},
                {EMPTY, EMPTY, EMPTY, WALL},
                {EMPTY, WALL, EMPTY, WALL},
                {GATE, WALL, EMPTY, EMPTY}
        };
        int[][] expectedResult = new int[][]{
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
        };
        WallsGateBruteForce.wallsAndGate(rooms);
        for(int i = 0; i < rooms.length;i++) {
            Assert.assertArrayEquals(expectedResult[i],rooms[i]);
        }

    }
}