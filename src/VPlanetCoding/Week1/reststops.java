package VPlanetCoding.Week1;

import java.io.*;
import java.util.*;

public class reststops {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week1.reststops.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week1.reststops.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int rF = Integer.parseInt(st.nextToken());
        int rB = Integer.parseInt(st.nextToken());
        int[] location = new int[N];
        int[] tasteness = new int[N];
        Stack<Integer> restStopOrder = new Stack<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            location[i] = Integer.parseInt(st.nextToken());
            tasteness[i] = Integer.parseInt(st.nextToken());
        }

        int currentHighestTaste = 0;
        for(int i = N-1; i >= 0; i--) {
            if(tasteness[i] > currentHighestTaste) {
                currentHighestTaste = tasteness[i];
                restStopOrder.push(i);
            }
        }

        long currentLocation = 0;
        long speedDiff = rF - rB;
        long totalTaste = 0;

        while(!restStopOrder.isEmpty()) {
            int currentRest = restStopOrder.pop();
            long travelDistance = location[currentRest] - currentLocation;
            totalTaste += tasteness[currentRest] * travelDistance * speedDiff;
            currentLocation = location[currentRest];
        }



        out.println(totalTaste);
        out.close();
    }
}

