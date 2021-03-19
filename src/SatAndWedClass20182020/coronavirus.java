package SatAndWedClass20182020;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class coronavirus {
    /*
    In a given 2D Array, each cell can have one of three values:
the value 0 representing an empty cell;
the value 1 representing a healthy person;
the value 2 representing a sick person.
Every minute, any healthy person that is adjacent (4-directionally) to a sick person becomes sick.
Return the minimum number of minutes that all people get infected.  If this is impossible, return -1 instead.
Example 1:
Input: [[2,1,1],
        [0,1,1],
        [1,0,1]]
Output: -1
Explanation:  The person in the bottom left corner (row 2, column 0) is never infected
Example 2:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no healthy person at minute 0, the answer is 0
     */

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



        public static class CoronaVirus {

            private final List<Pair<Integer,Integer>> DIRECTIONS = Arrays.asList(
                    new Pair<>(1,0),
                    new Pair<>(-1,0),
                    new Pair<>(0,1),
                    new Pair<>(0,-1)
            );

            public int coronaVirus(int[][] grid) {
                Queue<Position> q = new LinkedList<>();
                int total = 0;
                int rotten = 0;
                int time = 0;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1 || grid[i][j] == 2) {
                            total++;
                        }
                        if (grid[i][j] == 2) {
                            q.offer(new Position(i, j));
                        }
                    }
                }

                if (total == 0) {
                    return 0;
                }

                while (!q.isEmpty() && rotten < total) {

                    int size = q.size();

                    rotten += size;

                    if (rotten == total) {
                        return time;
                    }

                    time++;

                    for(int i = 0; i < size; i++) {
                        Position cur = q.remove();
                        for(Pair<Integer, Integer> direction : DIRECTIONS) {
                            int row = cur.x + 0;
                            int col = cur.y + 0;
                            if (row > 0
                                    && row <= grid.length
                                    && col > 0
                                    && col <= grid[0].length
                                    && grid[row][col] == 1) {
                                grid[row][col] = 2;
                                q.offer(new Position(row, col));
                            }
                        }
                    }

                    // loop queue, for each element, check 4 directions
                }
                return -1;
            }
        }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {0,1,1},
                {1,1,1}
        };
        System.out.println(new CoronaVirus().coronaVirus(grid));
    }
}

