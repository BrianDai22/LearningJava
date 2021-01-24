import java.io.*;
import java.util.*;

public class dancemoves {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("dancemoves.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dancemoves.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st.nextToken());
        int pairs = Integer.parseInt(st.nextToken());
        int[] premovedCows = new int[cows + 2];
        int[] beforeMovedCows = new int[cows + 2];
        Set<int[]> data = new HashSet<>();
        for (int i = 1; i <= cows; i++) {
            premovedCows[i] = i;
            beforeMovedCows[i] = i;
        }
        for (int i = 0; i < pairs; i++) {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int temp = premovedCows[start];
            premovedCows[start] = premovedCows[end];
            premovedCows[end] = temp;
        }
        int sizeOfSet = data.size();
        while (data.size() == sizeOfSet) {
            for (int i = 1; i <= cows; i++) {
                int temp = beforeMovedCows[i];
                beforeMovedCows[i] = beforeMovedCows[premovedCows[i]];
                beforeMovedCows[premovedCows[i]] = temp;
            }
            data.add(beforeMovedCows);
            sizeOfSet++;
        }
        for(int[] x: data) {
            System.out.println(Arrays.toString(x));
        }
        out.println();
        out.close();
    }
}
