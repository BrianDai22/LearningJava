package USACOSILVER.Week5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class fenceplan2 {

    public static class Location {
        int x;
        int y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class BoundingBox {
        int leftX;
        int rightX;
        int bottomY;
        int topY;

        BoundingBox(int leftX, int rightX, int bottomY, int topY) {
            this.leftX = leftX;
            this.rightX = rightX;
            this.bottomY = bottomY;
            this.topY = topY;
        }
    }

    public static int[] moonet = new int[100000];
    public static Location[] cowLocation;
    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.USOPEN2019.fenceplan.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.USOPEN2019.fenceplan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cowLocation = new Location[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(f.readLine());
            cowLocation[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int cow1 = Integer.parseInt(st.nextToken());
            int cow2 = Integer.parseInt(st.nextToken());
            if(!map.containsKey(cow1)) {
                map.put(cow1, new ArrayList<>());
            }
            map.get(cow1).add(cow2);
            if(!map.containsKey(cow2)) {
                map.put(cow2, new ArrayList<>());
            }
            map.get(cow2).add(cow1);
        }


        int moonetId = 0;
        int lowestP = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            if(moonet[i] == 0) {
                BoundingBox bb = new BoundingBox(Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 0);
                visit(i, ++moonetId, bb);
                lowestP = Math.min(lowestP, 2 * Math.abs(bb.leftX - bb.rightX) + 2 * Math.abs(bb.bottomY - bb.topY));
            }
        }

        out.println(lowestP);
        out.close();
    }

    public static void visit(int cowId, int moonetID, BoundingBox bb) {
        moonet[cowId] = moonetID;
        bb.rightX = Math.max(bb.rightX, cowLocation[cowId].x);
        bb.leftX = Math.min(bb.leftX, cowLocation[cowId].x);
        bb.topY = Math.max(bb.topY, cowLocation[cowId].y);
        bb.bottomY = Math.min(bb.bottomY, cowLocation[cowId].y);
        for(int neighbor: map.get(cowId+1)) {
            if(moonet[neighbor] == 0) {
                visit(neighbor-1, moonetID, bb);
            }
        }
    }

}
