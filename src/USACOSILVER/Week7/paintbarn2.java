package USACOSILVER.Week7;

import java.io.*;
import java.util.StringTokenizer;

public class paintbarn2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2019.paintbarn.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2019.paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int coordsAmount = Integer.parseInt(st.nextToken());
        int layerAmount = Integer.parseInt(st.nextToken());
        int[][] grid = new int[1001][1001];
        for(int i = 0; i < coordsAmount; i++) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = x1; j < x2; j++) {
                grid[j][y1]++;
                grid[j][y2]--;
            }
        }
        int answer = 0;
        for(int i = 0; i < grid.length-1; i++) {
            for(int j = 0; j < grid.length-1; j++) {
                if(grid[i][j] == layerAmount) {
                    answer++;
                }
                grid[i][j+1] += grid[i][j];
            }
        }
        out.println(answer);
        out.close();
    }
}
