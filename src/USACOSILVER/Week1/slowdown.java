package USACOSILVER.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class slowdown {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("slowdown.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
        int slowdownPoints = Integer.parseInt(f.readLine());
        int[][] slowdownPointArr = new int[slowdownPoints][slowdownPoints];
        int seconds = 0;
        int secondsPerMeter = 1;
        int meters = 0;
        for (int i = 0; i < slowdownPoints; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            if (st.nextToken().equals("T")) {
                slowdownPointArr[i][1] = Integer.parseInt(st.nextToken());
            } else {
                slowdownPointArr[i][0] = 1;
                slowdownPointArr[i][1] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(slowdownPointArr, Comparator.comparingInt(a -> a[1]));
        //System.out.println(Arrays.deepToString(slowdownPointArr));
        while (meters < 1000) {
            break;
        }

        out.println(seconds);
        out.close();
    }
}
/*
seconds += secondsPerMeter;
                if(seconds % secondsPerMeter == 0) {
                    meters++;
                }
                if(meters == distance[i] || seconds == time[i]) {
                    secondsPerMeter++;
                    break;
                }
 */