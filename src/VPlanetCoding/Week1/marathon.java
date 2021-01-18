package VPlanetCoding.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class marathon {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        int amtOfCoords = Integer.parseInt(f.readLine());
        int[] x = new int[amtOfCoords];
        int[] y = new int[amtOfCoords];
        for(int i = 0; i < amtOfCoords; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int maximumDistance = 0;
        for(int i = 0; i < amtOfCoords-1; i++) {
            maximumDistance += Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
        }
        //System.out.println(maximumDistance);
        int biggestSkip = 0;
        for(int i = 1; i < amtOfCoords-1; i++) {
            int skip = Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
            int extraDistance = maximumDistance - (Math.abs(x[i-1] - x[i]) + Math.abs(y[i-1] - y[i])
                    + Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]));
            biggestSkip = Math.max(maximumDistance - skip - extraDistance, biggestSkip);
        }

        out.println(maximumDistance - biggestSkip);
        out.close();
    }
}
