import java.io.*;
import java.util.StringTokenizer;

public class promote {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("promote.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        int[] before = new int[4];
        int[] after = new int[4];
        int[] answer = new int[3];
        int count = 0;

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            before[i] = Integer.parseInt(st.nextToken());
            after[i] = Integer.parseInt(st.nextToken());
        }


        answer[0] = before[3] - after[3];
        answer[1] = answer[0] + before[2] - after[2];
        answer[2] = answer[1] + before[1] - after[1];


        out.println(Math.abs(answer[2]));
        out.println(Math.abs(answer[1]));
        out.println(Math.abs(answer[0]));

        out.close();
    }
}
