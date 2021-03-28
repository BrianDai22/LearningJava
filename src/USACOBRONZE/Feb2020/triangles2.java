package USACOBRONZE.Feb2020;

import java.io.*;
import java.util.*;

public class triangles2 {
    public static class Coordinate {
        double x;
        double y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2020.triangles2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2020.triangles2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int amountOfCoordinates = Integer.parseInt(st.nextToken());
        Coordinate[] coordinates = new Coordinate[amountOfCoordinates];
        for(int i = 0; i < amountOfCoordinates; i++) {
            st = new StringTokenizer(f.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Map<Coordinate, ArrayList<Coordinate>> usableCoordinates = new HashMap<>();

        for(int i = 0; i < amountOfCoordinates; i++) {
            usableCoordinates.put(coordinates[i], new ArrayList<>());
            for(int j = i + 1; j < amountOfCoordinates; j++) {
                if(coordinates[i].x == coordinates[j].x || coordinates[i].y == coordinates[j].y) {
                    usableCoordinates.get(coordinates[i]).add(coordinates[j]);
                }
            }
        }

        double answer = 0;
        for(int i = 0; i < amountOfCoordinates; i++) {
            if(usableCoordinates.get(coordinates[i]).isEmpty()) {
                continue;
            }
            Coordinate key = coordinates[i];
            for(Coordinate coord: usableCoordinates.get(key)) {
                for(int j = 0; j < amountOfCoordinates; j++) {
                    if(coordinates[j] != key && coordinates[j] != coord) {
                        answer += ((key.x * (coord.y-coordinates[j].y)) +
                                (coord.x * (coordinates[j].y - key.y)) + (coordinates[j].x * (key.y-coord.y))) / 2;
                    }
                }
            }
        }

        System.out.println(answer);

        out.println();
        out.close();
    }
}
