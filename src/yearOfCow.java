import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yearOfCow {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("yearOfCow.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("yearOfCow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] years = new int[N];
        for(int i = 0; i < N; i++) {
            years[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(years);

    }
}
