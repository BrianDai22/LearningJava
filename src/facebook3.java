import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class facebook3 {
    private static Set<Pair<Integer, Integer>> set = new HashSet<>();
    private static final List<Pair<Integer,Integer>> DIRECTIONS = Arrays.asList(
            new Pair<>(1,0),
            new Pair<>(-1,0),
            new Pair<>(0,1),
            new Pair<>(0,-1)
    );

    public static int find(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && !set.contains(new Pair<>(i,j))) {
                    findHelper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void findHelper(char[][] grid, int i, int j) {
        Pair<Integer, Integer> current = new Pair<>(i,j);
        if(set.contains(current)) {
            return;
        }

        set.add(current);

        for(Pair<Integer,Integer> direction: DIRECTIONS) {
            int row = i + direction.getKey();
            int col = j + direction.getValue();
            if (row < 0 || row >= grid.length
                    || col < 0
                    || col >= grid[0].length
                    || grid[row][col] == '0') {
                continue;
            }
            if(set.contains(new Pair<>(row,col))) {
                continue;
            }
            findHelper(grid, i, j);
        }
    }
        public static void main(String[] args) {
        char[][] grid = {
                "110".toCharArray(),
                "110".toCharArray(),
                "001".toCharArray(),
        };
        System.out.println(find(grid));
    }
}
