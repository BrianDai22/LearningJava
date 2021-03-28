package USACOBRONZE.Feb2021;

import java.io.*;
import java.util.*;

public class dancemoves {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO20202021PROBLEMS.dancemoves.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO20202021PROBLEMS.dancemoves.out")));
        //UNCOMMENT WHEN SUBMIT TO USACO WEBSITE BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st.nextToken());
        int pairs = Integer.parseInt(st.nextToken());
        int[] cowsArr = new int[cows];
        int[] finalCowsArr = new int[cows];
        int[][] swaps = new int[pairs][2];
        ArrayList<Set<Integer>> freq = new ArrayList<>();
        for(int i = 0; i < cows; i++) {
            freq.add(new HashSet<>());
            freq.get(i).add(i + 1);
            cowsArr[i] = i + 1;
            finalCowsArr[i] = i + 1;
        }
        for(int i = 0; i < pairs; i++) {
            st = new StringTokenizer(f.readLine());
            swaps[i][0] = Integer.parseInt(st.nextToken())-1;
            swaps[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        boolean equals = false;
        while (!equals) {
            for(int i = 0; i < pairs && !equals; i++) {
                int temp = cowsArr[swaps[i][0]];
                cowsArr[swaps[i][0]] = cowsArr[swaps[i][1]];
                cowsArr[swaps[i][1]] = temp;
                freq.get(cowsArr[swaps[i][0]]-1).add(swaps[i][0] + 1);
                freq.get(cowsArr[swaps[i][1]]-1).add(swaps[i][1] + 1);
                equals = Arrays.equals(cowsArr, finalCowsArr);
            }
        }
        for(Set<Integer> x: freq) {
            System.out.println(x.size());
        }
    }
}
