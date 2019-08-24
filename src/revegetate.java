import java.io.*;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int[] choice1 = new int[150];
        int[] choice2 = new int[150];

        for(int i = 0; i < 150; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            choice1[i] = Integer.parseInt(st.nextToken());
            choice2[i] = Integer.parseInt(st.nextToken());
        }



    }
}

