package USACO.Dec2018;

import java.io.*;
import java.util.StringTokenizer;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2018.mixmilk.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2018.mixmilk.out"))); {

            StringTokenizer st = new StringTokenizer(f.readLine());
            int bucketSize = Integer.parseInt(st.nextToken());
            int bucket = Integer.parseInt(st.nextToken());
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            int bucketSize2 = Integer.parseInt(st2.nextToken());
            int bucket2 = Integer.parseInt(st2.nextToken());
            StringTokenizer st3 = new StringTokenizer(f.readLine());
            int bucketSize3 = Integer.parseInt(st3.nextToken());
            int bucket3 = Integer.parseInt(st3.nextToken());

            for(int i = 0; i < 99; i++) {
                if(bucket + bucket2 > bucketSize2) {
                    bucket = bucket + bucket2 - bucketSize2;
                    bucket2 = bucketSize2;
                } else {
                    bucket2 += bucket;
                    bucket = 0;
                }
                if(bucket2 + bucket3 > bucketSize3) {
                    bucket2 = bucket2 + bucket3 - bucketSize3;
                    bucket3 = bucketSize3;
                } else {
                    bucket3 += bucket2;
                    bucket2 = 0;
                }
                if(bucket3 + bucket > bucketSize) {
                    bucket3 = bucket3 + bucket - bucketSize;
                    bucket = bucketSize;
                } else {
                    bucket += bucket3;
                    bucket3 = 0;
                }

            }
            if(bucket + bucket2 > bucketSize2) {
                bucket = bucket + bucket2 - bucketSize2;
                bucket2 = bucketSize2;
            } else {
                bucket2 += bucket;
                bucket = 0;
            }

            out.println(bucket);
            out.println(bucket2);
            out.println(bucket3);
            out.close();
        }
    }
}
