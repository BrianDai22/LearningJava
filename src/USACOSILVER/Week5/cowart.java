package USACOSILVER.Week5;

import java.util.*;
import java.io.*;

public class cowart {

    final public static int[] DX = {-1, 0, 0, 1};
    final public static int[] DY = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("cowart.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowart.out")));
        StringTokenizer tok = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(tok.nextToken());
        
        char[][] normal = new char[n][n];
        for (int i = 0; i < n; i++) {
            normal[i] = f.readLine().toCharArray();
        }
        char[][] blind = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (normal[i][j] == 'G') {
                    blind[i][j] = 'R';
                } else {
                    blind[i][j] = normal[i][j];
                }
            }
        }
        int regColors = DFSHelper(normal, n);
        int blindColors = DFSHelper(blind, n);
        out.println(regColors + " " + blindColors);
        out.close();
    }

    public static int DFSHelper(char[][] grid, int n) {
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    res++;
                    DFS(grid, visited, i, j, n);
                }
            }
        }
        return res;
    }

    public static void DFS(char[][] grid, boolean[][] visited, int x, int y, int n) {
        visited[x][y] = true;
        for (int i = 0; i < DX.length; i++) {
            if (inbounds(x + DX[i], y + DY[i], n) && !visited[x + DX[i]][y + DY[i]] && grid[x][y] == grid[x + DX[i]][y + DY[i]]) {
                DFS(grid, visited, x + DX[i], y + DY[i], n);
            }
        }
    }
    public static boolean inbounds(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
