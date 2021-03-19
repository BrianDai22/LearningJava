package USACO.Feb2020;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class swap2 {

    public static class StartAndEnd {
        int start;
        int end;
        StartAndEnd(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2020.swap.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2020.swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int cows = Integer.parseInt(st.nextToken());
        int startAndEndAmount = Integer.parseInt(st.nextToken());
        int loopAmount = Integer.parseInt(st.nextToken());
        int[] cowsArr = new int[cows];
        StartAndEnd[] sections = new StartAndEnd[startAndEndAmount];
        for(int i = 0; i < cows; i++) {
            cowsArr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(cowsArr));
        for(int i = 0; i < startAndEndAmount; i++) {
            st = new StringTokenizer(f.readLine());
            sections[i] = new StartAndEnd(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }
        //System.out.println(Arrays.toString(sections));
        //reverse(sections[0].start,sections[0].end,cowsArr);
        //System.out.println(Arrays.toString(cowsArr));
        for(int i = 0; i < loopAmount; i++) {
            for(int j = 0; j < startAndEndAmount; j++) {
                reverse(sections[j].start, sections[j].end, cowsArr);
            }
        }

        //System.out.println(Arrays.toString(cowsArr));
        for(int i = 0; i < cows; i++) {
            out.println(cowsArr[i]);
        }
        out.close();

    }

    public static void reverse(int start, int end, int[] cowsArr) {
        int len = end - start;
        if(len <= 0) {
            return;
        }

        int len2 = len >> 1;
        int temp;

        for (int i = 0; i < len2; ++i) {
            temp = cowsArr[start + i];
            cowsArr[start + i] = cowsArr[end - i - 1];
            cowsArr[end - i - 1] = temp;
        }
    }
}
