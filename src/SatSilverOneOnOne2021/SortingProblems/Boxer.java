package SatSilverOneOnOne2021.SortingProblems;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boxer {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("Boxer.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Boxer.out")));
        int boxers = Integer.parseInt(f.readLine());
        Integer[] weightOfBoxers = new Integer[boxers];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < boxers; i++) {
            weightOfBoxers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weightOfBoxers, Collections.reverseOrder());
        boolean[] isGood = new boolean[weightOfBoxers[0]+2];
        int numOfUniqueBoxers = 0;

        for(int i = 0; i < weightOfBoxers.length; i++) {
            if(!isGood[weightOfBoxers[i]]) {
                isGood[weightOfBoxers[i]] = true;
                numOfUniqueBoxers++;
            } else if(!isGood[weightOfBoxers[i]+1]) {
                isGood[weightOfBoxers[i]+1] = true;
                numOfUniqueBoxers++;
            } else if(!isGood[weightOfBoxers[i]-1] && weightOfBoxers[i]-1 != 0) {
                isGood[weightOfBoxers[i]-1] = true;
                numOfUniqueBoxers++;
            }
        }

        out.println(numOfUniqueBoxers);
        out.close();
    }
}
