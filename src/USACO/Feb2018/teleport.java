package USACO.Feb2018;

import java.io.*;
import java.util.StringTokenizer;

public class teleport {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2018.teleport.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2018.teleport.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        out.println(Math.min(Math.min(Math.abs(a-y) + Math.abs(b-x),Math.abs(a-x) + Math.abs(b-y)),Math.abs(a-b)));
        out.close();


    }

}
