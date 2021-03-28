package USACOBRONZE.Dec2018;

import java.io.*;
import java.util.StringTokenizer;

public class blist {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2018.blist.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2018.blist.out")));

        int cows = Integer.parseInt(f.readLine());
        int[] start = new int[cows];
        int[] end = new int[cows];
        int[] bucketNeeded = new int[cows];
        int minimumBuckets = 0;
        int[] transcript = new int[1000];

        for(int i = 0; i < cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
            bucketNeeded[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < cows; i++) {
            for(int j = start[i]; j < end[i]; j++) {
                    transcript[j] += bucketNeeded[i];
                }
            }

        for(int i = 0; i < transcript.length; i++) {
            minimumBuckets = Math.max(transcript[i],minimumBuckets);
        }

        out.println(minimumBuckets);
        out.close();
        }
}
