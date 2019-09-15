import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class traffic {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

        int miles = Integer.parseInt(f.readLine());
        String[] ramps = new String[miles];
        int[] minCars = new int[miles];
        int[] maxCars = new int[miles];

        for(int i = 0 ; i < miles; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            ramps[i] = st.nextToken();
            minCars[i] = Integer.parseInt(st.nextToken());
            maxCars[i] = Integer.parseInt(st.nextToken());

        }
        System.out.println(Arrays.toString(ramps));
        System.out.println(Arrays.toString(minCars));
        System.out.println(Arrays.toString(maxCars));

        out.println();
        out.close();
    }
}
