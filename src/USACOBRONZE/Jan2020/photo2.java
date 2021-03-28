package USACOBRONZE.Jan2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class photo2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Jan2020.photo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2020.photo2.out")));
        int N = Integer.parseInt(f.readLine());
        int[] b = new int[N+2];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            int[] ans = new int[N+2];
            boolean isGood = true;
            int[] freq = new int[N+2];
            ans[1] = i;
            freq[ans[1]]++;
           for(int j = 2; j <= N; j++) {
               ans[j] = b[j-1] - ans[j-1];
               if(ans[j] < 1 || ans[j] > N) {
                   isGood = false;
                   break;
               }
               freq[ans[j]]++;
               if(freq[ans[j]] != 1) {
                   isGood = false;
                   break;
               }
           }
           if(isGood) {
               for(int k = 1; k <= N; k++) {
                   if(k == 1) {
                       out.print(ans[k]);
                   } else {
                       out.print(" " + ans[k]);
                   }
               }
               break;
           }

        }
        out.close();
    }
}
