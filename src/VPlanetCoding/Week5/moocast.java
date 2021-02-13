package VPlanetCoding.Week5;

import java.io.*;
import java.util.*;
public class moocast {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] canTransmit = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int squareDist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                if(squareDist <= p[i] * p[i]) {
                    canTransmit[i][j] = true;
                }
            }
        }
        int result = 1;
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            result = Math.max(result, DFS(i, visited, canTransmit));
        }
        out.println(result);
        out.close();
    }

    public static int DFS(int curr, boolean[] visited, boolean[][] canTransmit) {
        if(visited[curr]) {
            return 0;
        }
        visited[curr] = true;
        int result = 1;
        for(int i = 0; i < canTransmit[curr].length; i++) {
            if(canTransmit[curr][i]) {
                result += DFS(i, visited, canTransmit);
            }
        }
        return result;
    }

}
