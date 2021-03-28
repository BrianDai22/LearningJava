package USACOSILVER.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention2 {

    private static int N;
    private static int M;
    private static int C;
    private static int[] cows;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2018.convention.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2018.convention.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        cows = new int[N];
        for(int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);

        out.println(binarySearch(0, cows[cows.length-1]));
        out.close();

    }

    public static boolean possible(int waitTime) {
        int buses = 1;
        int firstCow = cows[0];
        int firstCowIndex = 0;

        for(int i = 1; i < N; i++) {
            if(cows[i] - firstCow > waitTime || i - firstCowIndex >= C) {
                buses += 1;
                firstCow = cows[i];
                firstCowIndex = i;
            }
        }

        if(buses <= M) {
            return true;
        } else {
            return false;
        }
    }

    public static int binarySearch(int left, int right) {
        if(left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if(possible(mid)) {
            return binarySearch(left, mid);
        } else {
            return binarySearch(mid+1, right);
        }
    }

}
