package USACO.Jan2019;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("USACO.Jan2019.sleepy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2019.sleepy.out")));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                answer = i;
            } else {
                break;
            }

        }
        pw.println(answer);
        pw.close();
    }
}
