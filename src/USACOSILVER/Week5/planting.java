package USACOSILVER.Week5;

import java.io.*;
import java.util.StringTokenizer;

public class planting {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week5.planting.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week5.planting.out")));

        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[1000000];
        int amountOfSeeds = 0;

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[Integer.parseInt(st.nextToken())-1]++;
            arr[Integer.parseInt(st.nextToken())-1]++;
        }

        for(int i = 0; i < N-1; i++) {
            amountOfSeeds = Math.max(amountOfSeeds, arr[i]);
        }

        out.println(amountOfSeeds+1);
        out.close();
    }
}
