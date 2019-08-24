import java.io.*;
import java.util.StringTokenizer;

public class herding {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int[] data = new int[3];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }



        }
}
