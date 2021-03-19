package VPlanetCoding.Week9;

import java.io.*;
import java.util.*;
public class pails {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2016.pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2016.pails.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[x+1][y+1];
        visited[0][0] = true;
        for(int p = 0; p < k; p++) {
            boolean[][] next = new boolean[x+1][y+1];
            for(int i = 0; i < visited.length; i++) {
                for(int j = 0; j < visited[i].length; j++) {
                    if(!visited[i][j]) {
                        continue;
                    }
                    next[i][j] = true;
                    next[0][j] = true;
                    next[x][j] = true;
                    next[i][0] = true;
                    next[i][y] = true;
                    int moveRight = Math.min(i, y - j);
                    next[i - moveRight][j + moveRight] = true;
                    int moveLeft = Math.min(x - i, j);
                    next[i + moveLeft][j - moveLeft] = true;
                }
            }
            visited = next;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[i].length; j++) {
                if(!visited[i][j]) {
                    continue;
                }
                result = Math.min(result, Math.abs(i+j-m));
            }
        }
        out.println(result);
        out.close();
    }
}