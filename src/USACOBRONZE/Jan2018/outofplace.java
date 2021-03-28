package USACOBRONZE.Jan2018;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class outofplace {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Jan2018.outofplace.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Jan2018.outofplace.out")));

        int size = Integer.parseInt(f.readLine());
        int[] arr = new int[size];

        for(int i =0; i < size;i++) {
            StringTokenizer st= new StringTokenizer(f.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = arr.clone();
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));



/*
        int diff = 0;
        int diffRealPos = 0;

        for(int i = 0; i < size; i++) {
            if(arr[i] != arr2[i]) {
                diff = arr[i];
            }
        }
        */
        /*
        for(int i = 0; i < size; i++) {
            if(arr[diff] > arr[i]) {
                diffRealPos = i;
            }
        }

         */

        /*

        int answer = 0;
        int temp = 0;
        int temp2 = 0;
        int dup = 0;

        for (int i = 0; i < size; i++) {
            if(arr[i] != arr2[i]) {
                temp = i;
            }
        }

        for(int i = 0; i < size; i++) {
            if(arr[temp] == arr2[i]) {
                temp2 = i;
                break;
            }
        }

        System.out.println(temp);
        System.out.println(temp2);

        for(int i = temp2; i < temp; i++) {
            for(int j = i + 1; j < temp; j++) {
                if(arr[i] == arr[j]) {
                    dup++;
                }
            }
        }

        System.out.println(dup);

        answer = temp - temp2 - dup;

         */

        int answer = 0;
        //int answer2 = 0;

        for(int i = 0; i < size; i++) {
            if(arr[i] != arr2[i]) {
                answer++;
            }
        }
        /*
        for(int i = 0; i < size; i++) {
            if(arr2[i] > arr[i]) {
                answer2++;
            }
        }

         */

        //out.println(Math.max(answer,answer2));
        out.println(answer-1);
        out.close();
    }
}
