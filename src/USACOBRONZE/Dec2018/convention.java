package USACOBRONZE.Dec2018;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2018.convention.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2018.convention.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cowAmount = Integer.parseInt(st.nextToken());
        int busAmount = Integer.parseInt(st.nextToken());
        int busSpaceAmount = Integer.parseInt(st.nextToken());
        int[][] buses = new int[busAmount][busSpaceAmount];
        int answer = 0;
        int[] cowsTimes = new int[cowAmount];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < cowAmount; i++) {
            cowsTimes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cowsTimes);
        int temp = 0;
        boolean breakOrNo = false;

        for(int i = 0; i < busAmount; i++) {
            for(int j = 0; j < busSpaceAmount; j++) {
                if(temp >= cowAmount) {
                    breakOrNo = true;
                    break;
                }
                buses[i][j] = cowsTimes[temp]+1;
                temp++;
            }
            if(breakOrNo) {
                break;
            }
        }
        //System.out.println(Arrays.deepToString(buses));

        for(int i = 0; i < busAmount; i++) {
            for(int j = 1; j < busSpaceAmount; j++) {
                if(buses[i][j] == 0) {
                    break;
                }
                answer = Math.max(buses[i][j] - buses[i][0], answer);
            }
        }

        out.println(answer);
        out.close();

    }
}
