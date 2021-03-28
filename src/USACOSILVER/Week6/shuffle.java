package USACOSILVER.Week6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shuffle {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week6.shuffle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week6.shuffle.out")));

        int cows= Integer.parseInt(f.readLine());
        int[] order = new int[cows+1];
        int[] newOrder = new int[cows+1];
        int[] after = new int[cows+1];
        int[] before = new int[cows+1];

        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i <= cows; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(f.readLine());
        for(int i = 1; i <= cows; i++) {
            after[i] = Integer.parseInt(st2.nextToken());
        }

        int index = 0;
        for(int i = 1; i <= cows; i++) {
            newOrder[index] = order[i];
            index++;
        }

        int temp = 0;
        for(int i = 1; i <= cows; i++) {
            temp = order[i];
            newOrder[temp] = i;
        }

        int position = 0;
        for(int i = 1; i <= cows; i++) {
            position = i;
            for(int j = 1; j <= 3; j++) {
                position = newOrder[position];
            }
            before[position] = after[i];
        }

        for(int i = 1; i <= cows; i++) {
            out.println(before[i]);
        }

        System.out.println(Arrays.toString(before));

        out.close();

    }
}