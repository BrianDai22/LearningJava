package USACOBRONZE.USOPEN2019;

import java.io.*;

public class leftout {
    static int[][] grid;
    public static void main(String[] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.USOPEN2019.leftout.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.USOPEN2019.leftout.out")));

        int N = Integer.parseInt(f.readLine());
        grid = new int[N][N];
        //R = 0 & L = 1
        for (int i = 0; i < grid.length; i++) {
            String temp = f.readLine();
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = temp.charAt(j) == 'R' ? 0 : 1;
            }
        }
        for (int i = 1; i < N; i++) {
            grid[i][0] = grid[i][0] ^ grid[0][0];

        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j] ^ grid[i][0] ^ grid[0][j];
            }
        }

        if (count(1, 1, N - 1, N - 1, 0) == 0) {
            out.println(1 + " " + 1);
            out.close();
            return;
        }
        if (count(1, 1, N - 1, N - 1, 1) == N - 1) {
            for (int i = 1; i < N; i++) {
                if (count(i, 1, i, N, 1) == N - 1) {
                    out.println(++i + " 1");
                    out.close();
                    return;
                }
                for (int j = 1; j < N; j++) {
                    if (count(1, j, N, j, 1) == N - 1) {
                        out.println("1 " + ++j);
                        out.close();
                        return;
                    }
                }
            }
            out.println(-1);
            out.close();
            return;
        }

        if (count(1, 1, N - 1, N - 1, 1) == 1) {
            for(int i = 1; i < N; i++) {
                for(int j = 1; j < N; j++) {
                    if(grid[i][j] == 1) {
                        out.println(++i + " "+ ++j);
                        out.close();
                        return;
                    }
                }
            }
        }
        out.println(-1);
        out.close();
    }

    static int count(int i1, int j1, int i2, int j2, int target) {
        int counter = 0;
        for(int i = i1; i <= i2; i++) {
            for(int j = j1; j <= j2; j++) {
                if(grid[i][j] == target) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
