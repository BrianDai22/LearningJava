import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swap3 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("swap2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken()); // number of cows
        int m = Integer.parseInt(st.nextToken()); // numbers of pairs
        int k = Integer.parseInt(st.nextToken()); // number of repeats
        int[] cows = new int[100001];
        boolean[] visited = new boolean[100001];

        for(int i = 1; i <= n; i++) {
            cows[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = 0; j < (end-start+1)/2; j++) {
                int temp = cows[start + j];
                cows[start + j] = cows[end - j];
                cows[end - j] = temp;
             }
        }

        System.out.println(Arrays.toString(cows));

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int start = cows[i];
                ArrayList<Integer> swaps = new ArrayList<>();
                swaps.add(i);
                while(start != i) {
                    visited[start] = true;
                    swaps.add(start);
                    start = cows[start];
                }
                int mod = k % swaps.size();
                for(int j = 0; j < swaps.size(); j++) {
                    cows[swaps.get(j)] = swaps.get((mod + j) % swaps.size());
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            out.println(cows[i]);
        }
        out.close();
    }
}
