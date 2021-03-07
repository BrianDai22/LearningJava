package VPlanetCoding.Week9;

import java.util.*;
import java.io.*;

public class ccski {

    final public static int[] DX = {-1, 0, 0, 1};
    final public static int[] DY = {0, -1, 1, 0};

    public static int r;
    public static int c;
    public static int[][] elevations;
    public static int[][] waypts;
    public static int firstWay;

    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("ccski.in"));
        PrintWriter out = new PrintWriter(new FileWriter("ccski.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        elevations = new int[r][c];
        waypts = new int[r][c];
        firstWay = -1;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < c; j++)
                elevations[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < c; j++) {
                waypts[i][j] = Integer.parseInt(st.nextToken());
                if (firstWay == -1) firstWay = i * c + j;
            }
        }

        int low = 0, high = 1000000000;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (!BFS(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (!BFS(low)) {
            low++;
        }
        out.println(low);
        out.close();
    }

    public static boolean BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(firstWay);
        boolean[] used = new boolean[r * c];
        used[firstWay] = true;
        while (q.size() > 0) {
            int next = q.poll();
            int nextr = next / c;
            int nextc = next % c;
            for (int i = 0; i < DX.length; i++) {
                int code = (nextr + DX[i]) * c + nextc + DY[i];
                if (inbounds(nextr + DX[i], nextc + DY[i]) && !used[code] &&
                        Math.abs(elevations[nextr][nextc] - elevations[nextr + DX[i]][nextc + DY[i]]) <= x) {
                    q.offer(code);
                    used[code] = true;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (waypts[i][j] == 1 && !used[i * c + j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean inbounds(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
