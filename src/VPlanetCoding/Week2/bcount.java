package VPlanetCoding.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class bcount {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] prefix = new int[4][n+1];
        for(int i = 1; i <= n; i++) {
            int curr = Integer.parseInt(f.readLine());
            for(int j = 1; j <= 3; j++) {
                prefix[j][i] = prefix[j][i-1];
            }
            prefix[curr][i]++;
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println((prefix[1][b] - prefix[1][a-1]) + " " + (prefix[2][b] - prefix[2][a-1]) + " " + (prefix[3][b] - prefix[3][a-1]));
        }
        out.close();
    }
}
/*

 */