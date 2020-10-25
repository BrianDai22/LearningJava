import javafx.util.Pair;

import java.util.*;

public class BuildBridge {

    public static int row;
    public static int column;
    public static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int buildBridge(int[][] A) {
        int answer = Integer.MAX_VALUE;
        row = A.length;
        column = A[0].length;

        //search grid for an island
        boolean isGood = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (A[i][j] == 1) {
                    DFS(A, i, j);
                    isGood = true;
                    break;
                }
            }
            if (isGood) {
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (A[i][j] == 2) {
                    answer = Math.min(answer, BFS(A, i, j));
                    isGood = true;
                    break;
                }
            }
            if (isGood) {
                break;
            }
        }

        System.out.println(Arrays.deepToString(A));
        return answer;
    }

    public static void DFS(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[row][column];
        if (i < 0 || i >= row
                || j < 0
                || j >= column
                || grid[i][j] == 0
                || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        grid[i][j]++;
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
    }

    public static int BFS(int[][] grid, int i, int j) {
        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i,j});
        int answer = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int p = 0; p < size; p++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int x = direction[0] + current[0];
                    int y = direction[1] + current[1];
                    if (x < 0 || x >= row
                            || y < 0
                            || y >= column
                            || grid[x][y] == 2
                            || visited[x][y]) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return answer;
                    }
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(buildBridge(grid));
    }
}
/*
In a given 2D binary array A,
there are two islands.  (An island is a 4-directionally connected group of 1s)

Now, we need to build a bridge between 2 islands.
we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped. In another word, find the shortest length of the bridge.

Example 1:

Input: A =
[
	[0,1],
	[1,0]
]
Output: 1

Example 2:

Input: A =
[
	[0,1,0],
	[0,0,0],
	[0,0,1]
]
Output: 2

Example 3:

Input: A =
[
	[1,1,1,1,1],
	[1,0,0,0,1],
	[1,0,1,0,1],
	[1,0,0,0,1],
	[1,1,1,1,1]
]

Output: 1

----------------- init code -------------------

public class BuildBridge{
	public int buildBridge(int[][] A) {

	}
}
 */