package VPlanetCoding;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class trapped {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("trapped.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
        int haybales = Integer.parseInt(f.readLine());
        int[][] haybaleSizePosition = new int[haybales][2];
        for (int i = 0; i < haybales; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            haybaleSizePosition[i][0] = Integer.parseInt(st.nextToken());
            haybaleSizePosition[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(haybaleSizePosition, Comparator.comparingInt(a -> a[1]));
        int answer = 0;
        for(int i = 0; i < haybales-1; i++) {
            int originalArea = haybaleSizePosition[i+1][1] - haybaleSizePosition[i][1];
            int leftBale = i;
            int rightBale = i+1;
            while(leftBale >= 0 && rightBale <= haybales-1) {
                boolean broke = false;
                int currDist = haybaleSizePosition[rightBale][1] - haybaleSizePosition[leftBale][1];
                if(currDist > haybaleSizePosition[leftBale][0]) {
                    leftBale--;
                    broke = true;
                }
                if(currDist > haybaleSizePosition[rightBale][0]) {
                    rightBale++;
                    broke = true;
                }
                if(!broke) {
                    break;
                }
            }
            if(leftBale >= 0 && rightBale <= haybales-1) {
                answer += originalArea;
            }
        }
        out.println(answer);
        out.close();
    }
}
