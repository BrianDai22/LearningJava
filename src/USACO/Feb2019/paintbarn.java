package USACO.Feb2019;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class paintbarn {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2019.paintbarn.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2019.paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[1001][1001];
        while(n > 0) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                graph[i][y1]++;
                graph[i][y2]--;
            }
            n--;
        }
        System.out.println(Arrays.deepToString(graph));

        int totalArea = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(graph[i][j] == k) {
                    totalArea++;
                }
                graph[i][j+1] += graph[i][j];
            }
        }

        out.println(totalArea);
        out.close();

    }
}

/*
public class USACO.Feb2019.paintbarn
PreSum { public static void main(String[] args)
throws IOException { BufferedReader br = new BufferedReader(new FileReader("USACO.Feb2019.paintbarn.in"));
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2019.paintbarn.out")));
StringTokenizer st = new StringTokenizer(br.readLine());
int[][] grid = new int[1001][1001];
int N = Integer.parseInt(st.nextToken());
int K = Integer.parseInt(st.nextToken());
// Only mark where to pick up/drop off cans instead of recording coats of VPlanetCoding.Week7.paint.
for (int i = 0; i < N; i++) { st = new StringTokenizer(br.readLine());
int x1 = Integer.parseInt(st.nextToken());
int y1 = Integer.parseInt(st.nextToken());
int x2 = Integer.parseInt(st.nextToken());
int y2 = Integer.parseInt(st.nextToken());
for (int j = x1; j < x2; j++) {
grid[j][y1]++; // Mark pick up can since this position.
grid[j][y2]--; // Mark drop off can since this position. }
} // Record coats of VPlanetCoding.Week7.paint by prefix sum.
for (int i = 0; i <= 1000; i++) {
for (int j = 1; j <= 1000; j++) {
grid[i][j] += grid[i][j - 1]; }
} // Find answer. int ans = 0;
for (int i = 0; i <= 1000; i++) { for (int j = 0; j <= 1000; j++) { if (grid[i][j] == K) { ans++; } } } pw.println(ans); pw.close(); } }

 */
