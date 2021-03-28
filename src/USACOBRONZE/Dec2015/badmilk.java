package USACOBRONZE.Dec2015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class badmilk {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2015.badmilk.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2015.badmilk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[][] freqPerson = new int[N][M];
        int[][] transcript = new int[D][3];
        int[][] sick = new int[S][2];

        for(int i = 0; i < D; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            for(int j = 0; j < 3; j++) {
                transcript[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i = 0; i < S; i++) {
            StringTokenizer st3 = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2; j++) {
                sick[i][j] = Integer.parseInt(st3.nextToken());
            }
        }


        for(int i = 0; i < S; i++) {
            for (int j = 0; j < D; j++) {
                if (sick[i][1] > transcript[j][2] && sick[i][0] == transcript[j][0]) {
                    freqPerson[sick[i][0] - 1][transcript[j][1] - 1]++;
                } else {
                    if (!getSick(sick, transcript[j][0])) {
                        if (transcript[j][2] <= sick[i][1]) {
                            freqPerson[transcript[j][0] - 1][transcript[j][1] - 1]++;
                        }
                    }
                }
            }
        }
        int temp;
        int answer = 0;
        for(int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if(freqPerson[j][i] > 0) {
                    temp++;
                }
            }
            answer = Math.max(answer,temp);
        }


        System.out.println(Arrays.deepToString(transcript));
        System.out.println(Arrays.deepToString(sick));
        System.out.println(Arrays.deepToString(freqPerson));
        System.out.println(answer);

        out.println(answer);
        out.close();

    }
    public static boolean getSick(int[][] arr, int num) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][0] == num) {
                return true;
            }
        }
        return false;
    }
}
