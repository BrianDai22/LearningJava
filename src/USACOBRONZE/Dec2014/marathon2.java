package USACOBRONZE.Dec2014;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class marathon2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2014.marathon2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2014.marathon2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int sections = Integer.parseInt(st.nextToken());
        int skips = Integer.parseInt(st.nextToken());
        int[] x = new int[sections];
        int[] y = new int[sections];

        int totalDistance = 0;

        for(int i = 0; i < sections; i++) {
            st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < sections-1; i++) {
            totalDistance += Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i+1]);
        }

        System.out.println(totalDistance);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i < sections-1; i++) {
            int skipDistance = Math.abs(x[i-1] - x[i + 1]) + Math.abs(y[i-1] - y[i+1]);
            int noSkipDistance = Math.abs(x[i] - x[i - 1]) + Math.abs(x[i] - x[i + 1])
                    + Math.abs(y[i] - y[i - 1]) + Math.abs(y[i] - y[i + 1]);
            System.out.println(noSkipDistance-skipDistance);
            queue.add(noSkipDistance - skipDistance);
            if(queue.size() > skips) {
                queue.poll();
            }
        }

        for(Integer skipDistance: queue) {
            totalDistance -= skipDistance;
        }
        out.println(totalDistance);
        out.close();
    }

}
