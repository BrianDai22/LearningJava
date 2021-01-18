package VPlanetCoding.Week2;

import java.io.*;

public class cow {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("sumQuery.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sumQuery.out")));
        int N = Integer.parseInt(f.readLine());
        String s = f.readLine();
        long c = 0;
        long o = 0;
        long w = 0;
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) == 'C') {
                c++;
            } else if(s.charAt(i) == '0') {
                o += c;
            } else if(s.charAt(i) == 'W') {
                w+=o;
            }
        }
        out.println(w);
        out.close();
    }
}
