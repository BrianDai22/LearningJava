import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swap3 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken()); // number of cows
        int m = Integer.parseInt(st.nextToken()); // numbers of pairs
        int k = Integer.parseInt(st.nextToken()); // number of repeats

        int[] template = new int[n];
        for (int i = 0; i < n; i++) {
            template[i] = i;
        }

        for (int i = 0; i < m; i++) { // set template by swapping elements
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            while (start < end) {
                int temp = template[start];
                template[start] = template[end];
                template[end] = temp;
                start++;
                end--;
            }
        }

        int[] positions = new int[n]; //index is cowID, value is roomId the cow should go

        for(int i = 0; i < n; i++) {
            positions[template[i]] = i;
        }

        int[] answers = new int[n];
        for(int cowId = 0; cowId < n; cowId++) {
            ArrayList<Integer> swapRecords = new ArrayList<>();
            int position = cowId;
            swapRecords.add(position);
            int newPosition = positions[position];
            while(newPosition != position) {
                swapRecords.add(newPosition);
                newPosition = positions[newPosition];
            }
            int finalPosition = swapRecords.get(k % swapRecords.size());
            answers[finalPosition] = cowId+1;
        }

        for(int i = 0; i < n; i++) {
            out.println(answers[i]);
        }
        out.close();
    }
}
