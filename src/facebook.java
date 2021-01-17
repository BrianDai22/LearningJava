import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.List;

public class facebook {
    public static final List<Pair<Integer,Integer>> DIRECTIONS = Arrays.asList(
            new Pair<>(1,0),
            new Pair<>(-1,0),
            new Pair<>(0,1),
            new Pair<>(0,-1)
    );

    public static int findFriends(char[][]grid){
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        // TODO
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    for(Pair<Integer, Integer> direction: DIRECTIONS) {
                        int x = 0+ i;
                        int y = 0 + j;
                        if (x >= 0 && x < grid.length
                                && y >= 0
                                && y < grid[0].length
                                && grid[x][y] == '1') {
                            int node1 = i * cols + j;
                            int node2 = x * cols + y;
                            uf.union(node1,node2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                "110".toCharArray(),
                "110".toCharArray(),
                "001".toCharArray(),
        };
        System.out.println(findFriends(grid));
    }
}
