package VPlanetCoding.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class guessTheNumber {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2020.swap2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week8.swap3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
    }
}
