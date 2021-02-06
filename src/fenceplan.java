import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fenceplan {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] coords = new int[N+2][2];
        int[][] connections = new int[M+2][2];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2; j++) {
                coords[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2; j++) {
                connections[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 1; i <= M; i++) {
            int x1 = coords[connections[i][0]][0];
            int y1 = coords[connections[i][0]][1];
            int x2 = coords[connections[i][1]][0];
            int y2 = coords[connections[i][1]][1];
            int length = Math.abs(x1 - x2);
            int width = Math.abs(y1 - y2);
            int perimeter = 2 * (length + width);
            answer = Math.min(answer,perimeter);
        }

        out.println(answer);
        out.close();

    }
}
/*
 System.out.println("connection: " + connections[i][0]);
            System.out.println("connection2: " + connections[i][1]);
            System.out.println("x1: " + x1);
            System.out.println("y1: " + y1);
            System.out.println("x2: " + x1);
            System.out.println("y2: " + y2);
            answer = Math.min(answer, 2 * Math.abs(x2-x1+y2-y1));
            System.out.println("VPlanetCoding.Week5.perimeter: " + answer);
 */