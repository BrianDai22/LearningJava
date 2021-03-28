package USACOBRONZE.Feb2019;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class traffic {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2019.traffic.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2019.traffic.out")));

       int miles = Integer.parseInt(f.readLine());
       String[] ramps = new String[miles];
       int[] maxCars = new int[miles];
       int[] minCars = new int[miles];
       int finalMax = 999999;
       int finalMin = -1;
       int initialMax = 999999;
       int initialMin = -1;

       for(int i = 0; i < miles; i++) {
           StringTokenizer st = new StringTokenizer(f.readLine());
           ramps[i] = st.nextToken();
           minCars[i] = Integer.parseInt(st.nextToken());
           maxCars[i] = Integer.parseInt(st.nextToken());
       }

       for(int i = 0; i < miles; i++) {
           switch (ramps[i]) {
               case("none"):
                   finalMax = Math.min(maxCars[i], finalMax);
                   finalMin = Math.max(minCars[i], finalMin);

                   break;
               case("on"):
                   finalMax = finalMax + maxCars[i];
                   finalMin = finalMin + minCars[i];
                   break;

               case("off"):
                   finalMax = finalMax - minCars[i];
                   finalMin = finalMin - maxCars[i];
                   break;
           }
       }

        for(int i = miles-1 ; i >= 0; i--) {
            switch (ramps[i]) {
                case("none"):
                    initialMax = Math.min(maxCars[i], initialMax);
                    initialMin = Math.max(minCars[i], initialMin);

                    break;

                case("off"):
                    initialMax = initialMax + maxCars[i];
                    initialMin = initialMin + minCars[i];
                    break;

                case("on"):
                    initialMax = initialMax - minCars[i];
                    initialMin = initialMin - maxCars[i];
                    break;

            }

        }
        out.println(initialMin + " "+initialMax);
        out.println(finalMin + " "+finalMax);
        out.close();
    }
}















