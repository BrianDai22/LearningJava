package SatSilverOneOnOne2021.GraphTheory;

import java.util.Arrays;

public class Regions {
    public static char[][] matrix;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        m = 4;
        n = 4;
        matrix = new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 'O') {
                    DFS(matrix, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void DFS(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 'O') {
            return;
        }

        matrix[i][j] = 'X';
        DFS(matrix, i + 1, j);
        DFS(matrix, i - 1, j);
        DFS(matrix, i, j + 1);
        DFS(matrix, i, j - 1);
    }
}
