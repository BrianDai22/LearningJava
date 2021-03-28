package USACOBRONZE.USOPEN2019;

import java.io.*;
import java.util.StringTokenizer;

public class buckets {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.USOPEN2019.buckets.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.USOPEN2019.buckets.out")));
        int bX = 0;
        int bY = 0;
        int rX = 0;
        int rY = 0;
        int LX = 0;
        int LY = 0;

        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < 10; j++) {
                if(temp.charAt(j) == 'B') {
                    bX = i;
                    bY = j;
                }
                if(temp.charAt(j) == 'R') {
                    rX = i;
                    rY = j;
                }
                if(temp.charAt(j) == 'L') {
                    LX = i;
                    LY = j;
                }
            }
        }

        int barnToLake = Math.abs(bX - LX)  + Math.abs(bY-LY);
        int barnToRock = Math.abs(bX - rX)  + Math.abs(bY-rY);
        int rockToLake = Math.abs(rX - LX)  + Math.abs(rY-LY);

        if((bX == LX || bY == LY) && barnToLake == barnToRock + rockToLake) {
            out.println(barnToLake + 1);
            out.close();
        } else {
            out.println(barnToLake - 1);
            out.close();
        }
    }
}
