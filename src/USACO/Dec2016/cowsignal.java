package USACO.Dec2016;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2016.cowsignal.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2016.cowsignal.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] signal = new String[M];
        String[] signal2 = new String[M * K];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            signal[i] = st2.nextToken();
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                for (int h = 0; h < N; h++) {
                    for (int g = 0; g < K; g++) {
                        out.print(signal[i].charAt(h));
                    }
                }
                out.println();

            }
        }
            out.close();
        }
    }





