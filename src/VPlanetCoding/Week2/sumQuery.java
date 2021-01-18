package VPlanetCoding.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class sumQuery {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("sumQuery.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sumQuery.out")));
        int n = Integer.parseInt(f.readLine());
        int[] sum = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i < n; i++) {
            sum[i] = Integer.parseInt(st.nextToken())+sum[i-1];
        }
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            out.println(sum[y+1]-sum[x]);
        }
        out.close();
    }
}
