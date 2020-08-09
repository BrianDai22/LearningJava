import java.io.*;
import java.util.StringTokenizer;

public class convention2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("convention.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] cows = new int[N];
        for(int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        out.println();
        out.close();

    }

    public boolean possible(int waitTime) {

        return false;
    }

    public int binarySearch(int left, int right) {
        if(left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if(possible(mid)) {
            return binarySearch(left, mid);
        } else {
            return binarySearch(mid+1, right);
        }
    }

}
