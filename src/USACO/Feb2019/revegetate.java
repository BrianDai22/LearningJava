package USACO.Feb2019;

import java.io.*;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2019.revegetate.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2019.revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] one = new int[m+1];
        int[] two = new int[m+1];
        int[] answer = new int[n+1];

        for(int i = 1; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            one[i] = Integer.parseInt(st2.nextToken());
            two[i] = Integer.parseInt(st2.nextToken());
            if(one[i] > two[i]) {
                int temp = one[i];
                one[i] = two[i];
                one[i] = temp;
            }

        }

        for(int i = 1; i < n + 1; i++) {
            for(int grass = 1; grass < 5; grass++) {
                boolean ok = true;
                for(int k = 1; k < m + 1; k++) {
                    if(two[k] == i && answer[one[k]] == grass) {
                        ok = false;
                        break;
                    }

                }
                if(ok) {
                    answer[i] = grass;
                    break;
                }

            }

        }
        for(int i = 1; i <= n; i++) {
            out.print(answer[i]);
        }
        out.close();


    }
    /*
    private static int USACO.Feb2020.swap(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;

        }
        return a && b;
    }

     */
}

