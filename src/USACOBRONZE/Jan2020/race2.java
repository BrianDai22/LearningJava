package USACOBRONZE.Jan2020;

import java.io.*;
import java.util.StringTokenizer;

public class race2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Jan2020.race.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2020.race2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            out.println(speedy(K, Integer.parseInt(f.readLine())));
        }
        out.close();

    }

    public static int speedy(int maxDistance, int speedLimit) {
        int timeUsed = 0;
        int speedup = 0;
        int slowdown = 0;
        for(int i = 1;;i++) {
            speedup += i;
            timeUsed++;
            if(speedup+slowdown >= maxDistance) {
                return timeUsed;
            }

            if(i >= speedLimit) {
                slowdown += i;
                timeUsed++;
                if(speedup+slowdown >= maxDistance) {
                    return timeUsed;
                }
            }
        }
    }
}
