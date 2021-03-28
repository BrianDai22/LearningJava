package USACOSILVER.Week1;

import java.io.*;

public class even {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("even.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("even.out")));
    /*
    skipped bc took too much time thinking about problem w/o result
     */
        out.println();
        out.close();
    }
}
