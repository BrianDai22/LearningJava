package USACOSILVER.Week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lemonade {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week1.lemonade.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week1.lemonade.out")));
        int cows = Integer.parseInt(f.readLine());
        int lineSize = 0;
        int[] cowArray = new int[cows];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < cows; i++) {
            cowArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cowArray);
        for(int i = cowArray.length-1; i >= 0; i--) {
            if(cowArray[i] >= lineSize) {
                lineSize++;
            }
        }
        out.println(lineSize);
        out.close();
    }
}
