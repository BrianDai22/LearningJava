package USACO.Feb2020;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class triangles {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2020.triangles.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2020.triangles.out")));
        int numOfCoords = Integer.parseInt(f.readLine());
        StringTokenizer st;
        int[][] coordinates = new int[numOfCoords][2];
        for(int i = 0; i < numOfCoords; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 2; j++) {
                coordinates[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] coordinates2 = coordinates.clone();



        int answer = 0;
        for(int i = 0; i < numOfCoords; i++) {
            int biggestVert = 0;
            int biggestHori = 0;
            for(int j = 0; j < numOfCoords; j++) {
                if (coordinates2[i] == coordinates[j]) {
                    continue;
                }
                if (coordinates2[i][0] == coordinates[j][0]) {
                    //System.out.println(coordinates2[i][0] + " "+ coordinates2[i][1]);
                    //System.out.println(coordinates[j][0] + " "+ coordinates[j][1]);
                    biggestHori = Math.max(biggestHori, Math.abs(coordinates2[i][1] - coordinates[j][1]));
                    System.out.println(i + " h: "+biggestHori);
                }
                if(coordinates2[i][1] == coordinates[j][1]) {
                    //System.out.println(coordinates2[i][0] + " "+ coordinates2[i][1]);
                    //System.out.println(coordinates[j][0] + " "+ coordinates[j][1]);
                    biggestVert = Math.max(biggestVert, Math.abs(coordinates2[i][0] - coordinates[j][0]));
                    System.out.println(i + " v: " + biggestVert);
                }
            }
            answer = Math.max(biggestHori * biggestVert, answer);
        }

        out.println(answer);
        out.close();

    }
}
// System.out.println(coordinates2[i][0] + " "+ coordinates2[i][1]);
//System.out.println(coordinates[j][0] + " "+ coordinates[j][1]);
//System.out.println(biggestHori);
//System.out.println(biggestVert);
//System.out.println(Arrays.deepToString(coordinates));
        /*
        if (Math.abs(coordinates2[i][0] - coordinates[j][0]) > biggestHori) {
                    biggestHori = Math.abs(coordinates2[i][0] - coordinates[j][0]);
                }

                if (Math.abs(coordinates2[i][1] - coordinates[j][1]) > biggestVert) {
                    biggestVert = Math.abs(coordinates2[i][1] - coordinates[j][1]);
                }
         */