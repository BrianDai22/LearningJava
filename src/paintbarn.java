import java.io.*;
import java.util.StringTokenizer;

public class paintbarn {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[1001][1001];
        while(n > 0) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                graph[i][y1]++;
                graph[i][y2]--;
            }

            n--;
        }

        int totalArea = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(graph[i][j] == k) {
                    totalArea++;
                }
                graph[i][j+1] += graph[i][j];
            }
        }

        out.println(totalArea);
        out.close();

    }
}
