import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class rut {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("rut.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rut.out")));
        int cows = Integer.parseInt(f.readLine());
        int[][] coords = new int[cows][2];
        //int[][]

        for(int i = 0; i < cows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }

        //int[][] grid = new int[][];
        out.println();
        out.close();
        }
}
