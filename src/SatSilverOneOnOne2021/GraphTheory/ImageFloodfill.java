package SatSilverOneOnOne2021.GraphTheory;

import java.util.Arrays;

public class ImageFloodfill {
    public static int[][] image;
    public static int color;
    public static int ogColor;
    public static int sr;
    public static int sc;

    public static void main(String[] args) {
        image = new int[][]{{0,0,0}, {0,0,0}};
        sr = 1;
        sc = 1;
        ogColor = image[sr][sc];
        color = 2;

        DFSMarking(image, sr, sc);
        System.out.println(Arrays.deepToString(image));
    }
    private static void DFSMarking(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || grid[i][j] != ogColor) {
            return;
        }

        grid[i][j] = color;
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}
