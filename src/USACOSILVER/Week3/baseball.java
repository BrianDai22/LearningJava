package USACOSILVER.Week3;

import java.io.*;
import java.util.Arrays;

public class baseball {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("baseball.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        int n = Integer.parseInt(f.readLine());
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(vals);

        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j = i + 1; j < n; j++) {
                result += search(vals, i, j);
            }
        }
        out.println(result);
        out.close();
    }
    public static int search(int[] values, int x, int y) {
        int min = 2 * values[y] - values[x];
        int max = 3 * values[y] - 2 * values[x];
        return binSearch(values, max) - binSearch(values, min-1);
    }
    public static int binSearch(int[] values, int item) {
        int low = 0;
        int high = values.length-1;
        while (low < high-1) {
            int mid = (low+high)/2;
            if (values[mid] <= item) {
                low = mid;
            } else {
                high = mid;
            }
        }
        while (high >= 0 && values[high] > item) {
            high--;
        }
        return high+1;
    }
}
