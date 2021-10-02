package SatSilverOneOnOne2021.PrefixSum;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class seven {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int cows = Integer.parseInt(f.readLine());
        int[] cowID = new int[cows];
        for(int i = 0; i < cows; i++) {
            cowID[i] = Integer.parseInt(f.readLine());
        }
        long sum = 0;
        Map<Boolean, Long> preSum = new HashMap<>();
        preSum.put(true, 1L);
        for(int i = 0; i < cows; i++) {
            sum += cowID[i];
            if(preSum.containsKey(sum%7==0)) {

            }

        }
        out.close();
    }
}
