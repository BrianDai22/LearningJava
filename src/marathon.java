import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class marathon {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));

        int sections = Integer.parseInt(f.readLine());
        //int[] sectionDistance = new int[sections];
        int[] x = new int[sections];
        int[] y = new int[sections];

        int totalDistance = 0;

        for(int i = 0; i < sections; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < sections-1; i++) {
            totalDistance += Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i+1]);
        }
        //System.out.println(totalDistance);
        //System.out.println(Arrays.toString(x));
        //System.out.println(Arrays.toString(y));

        int biggestSkip = 0;
        for(int i = 1; i < sections-1; i++) {
            int skipDistance = Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]);
            //System.out.println(skipDistance);
            int noSkipDistance = Math.abs(x[i] - x[i - 1]) + Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i-1]) + Math.abs(y[i] - y[i + 1]);
            //System.out.println(noSkipDistance);
            biggestSkip = Math.max(noSkipDistance - skipDistance, biggestSkip);
            //System.out.println(biggestSkip);
        }


        out.println(totalDistance - biggestSkip);
        out.close();
    }

}
