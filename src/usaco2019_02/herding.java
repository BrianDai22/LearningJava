package usaco2019_02;

import java.io.*;
import java.util.StringTokenizer;

public class herding {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("usaco2019_02.herding.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("usaco2019_02.herding.out")));
        int N = Integer.parseInt(f.readLine());
        int[] data = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = Math.max((data[N-2]-data[0]), (data[N-1]-data[1]) - (N-2));

        out.close();


    }
    public int min(int[] data, int N) {
        if (data[N-2]-data[0] == N-2 && data[N-1]-data[N-2] > 2) {
            return 2;
        }
        if (data[N-1]-data[1] == N-2 && data[1]-data[0] > 2) {
            return 2;
        }

        for(int i = 0; i < N; i++) {

        }


    return 0;
    }

}
