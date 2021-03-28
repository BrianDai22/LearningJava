package USACOBRONZE.Dec2019;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gymnastics2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2019.gymnastics.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2019.gymnastics2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int[][] data = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < columns; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int length = columns * columns;
        int[][] transcript = new int[length][2];

        int temp = 0;
        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < columns; j++) {
                transcript[temp][0] = i + 1;
                transcript[temp][1] = j + 1;
                temp++;
            }
        }
        System.out.println(Arrays.deepToString(data));
        System.out.println(Arrays.deepToString(transcript));

        int num1;
        int num1Index;
        int num2;
        int num2Index;
        int count = 0;
        int result = 0;

        for(int i = 0; i < length; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            if(num1 >= num2) {
                continue;
            }
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(data[j], num1);
                num2Index = indexOf(data[j], num2);
                if(num1Index < num2Index) {
                    count++;
                }
            }
            if(count == rows) {
                result++;
            }
            count = 0;
        }

        count = 0;

        for(int i = 0; i < length; i++) {
            num1 = transcript[i][0];
            num2 = transcript[i][1];
            if(num1 >= num2) {
                continue;
            }
            for(int j = 0; j < rows; j++) {
                num1Index = indexOf(data[j], num1);
                num2Index = indexOf(data[j], num2);
                if(num2Index < num1Index) {
                    count++;
                }
            }
            if(count == rows) {
                result++;
            }
            count = 0;
        }



        out.println(result);
        out.close();
    }

    public static int indexOf(int[] a, int n) {
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == n) {
                result = i;
                break;
            }
        }
        return result;
    }
}
