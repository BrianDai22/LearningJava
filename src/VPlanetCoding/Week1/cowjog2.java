package VPlanetCoding.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowjog2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week1.cowjog2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week1.cowjog2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cowAmt = Integer.parseInt(st.nextToken());
        int timeAmount = Integer.parseInt(st.nextToken());
        int[] cowPos = new int[cowAmt];
        long[] finalDist = new long[cowAmt];
        for(int i = 0; i < cowAmt; i++) {
            st = new StringTokenizer(f.readLine());
            cowPos[i] = Integer.parseInt(st.nextToken());
            finalDist[i] = (long) Integer.parseInt(st.nextToken()) * timeAmount + cowPos[i];
        }
        long currentGroupSpeed = finalDist[cowAmt-1];
        int groups = 1;
        for(int i = cowAmt-2; i >= 0; i--) {
            if(finalDist[i] < currentGroupSpeed) {
                currentGroupSpeed = finalDist[i];
                groups++;
            }
        }
        /*
        System.out.println(Arrays.toString(cowPos));
        System.out.println(Arrays.toString(finalDist));
         */
        out.println(groups);
        out.close();
    }
}
/*
5 3
0 1
1 2
2 3
3 2
6 1
 */