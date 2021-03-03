import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class comfortable {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("comfortable.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comfortable.out")));

        int N = Integer.parseInt(f.readLine());
        int[][] grid = new int[N+2][N+2];
        int[][] coords = new int[N][2];
        int[] freqOfNearbyCow = new int[N];
        boolean[] comfortableOrNot = new boolean[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken())+1;
            coords[i][1] = Integer.parseInt(st.nextToken())+1;
            grid[coords[i][0]][coords[i][1]] = 1;
        }
        for(int i = 0; i < N; i++) {
            freqOfNearbyCow[i] = floodfill(grid, coords[i][0], coords[i][1]);
            if(freqOfNearbyCow[i] == 3) {
                comfortableOrNot[i] = true;
            }
        }
        out.println();
        out.close();
    }
    public static int floodfill(int[][] grid, int i, int j) {
        int count = 0;

        if (grid[i - 1][j] == 1) {
            count++;
        }

        if (grid[i][j - 1] == 1) {
            count++;
        }

        if (grid[i + 1][j] == 1) {
            count++;
        }

        if (grid[i][j + 1] == 1) {
            count++;
        }

        return count;
    }
}
