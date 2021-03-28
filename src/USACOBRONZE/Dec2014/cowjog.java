package USACOBRONZE.Dec2014;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowjog {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2014.cowjog.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2014.cowjog.out")));
        /*
        int cows = Integer.parseInt(f.readLine());
        int[][] cowsAndSpeed = new int[cows][2];
        int groups = 1;
        for(int i = 0; i < cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2; j++) {
                cowsAndSpeed[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < cows; i++) {
            if(cowsAndSpeed[i][0] - cowsAndSpeed[0][0] == 1) {
                cowsAndSpeed[i][1] = cowsAndSpeed[0][1];
                cowsAndSpeed[0][0] = cowsAndSpeed[i][0];
            } else {
                if(cowsAndSpeed[i][1] <= cowsAndSpeed[0][1]) {
                    if(cowsAndSpeed[i][0] - cowsAndSpeed[i-1][0] != 1) {
                        groups++;
                        cowsAndSpeed[0][0] = cowsAndSpeed[i][0];
                        cowsAndSpeed[0][1] = cowsAndSpeed[i][1];

                    }
                }

            }
        }

        //System.out.println(Arrays.deepToString(cowsAndSpeed));
        out.println(groups);
        out.close();
        */

        int N = Integer.parseInt(f.readLine());
        int[] speeds = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            Integer.parseInt(st.nextToken());
            speeds[i] = Integer.parseInt(st.nextToken());
        }
        int result = 1;
        int slowest = speeds[N-1];
        for(int i = N-2; i >= 0; i--) {
            if(speeds[i] <= slowest) {
                result++;
            }
            slowest = Math.min(slowest, speeds[i]);
        }
        out.println(result);
        out.close();



    }
}
