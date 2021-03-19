package USACO.Feb2018;

import java.io.*;
import java.util.*;

public class teleport3 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2018.teleport2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2018.teleport3.out")));

        Set<Integer> checkpoints = new HashSet<>();

        int n = Integer.parseInt(f.readLine());
        int[] startPoints = new int[n];
        int[] endPoints = new int[n];
        long base = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            startPoints[i] = Integer.parseInt(st.nextToken());
            endPoints[i] = Integer.parseInt(st.nextToken());
            int baseI = Math.abs(startPoints[i] - endPoints[i]);
            base += baseI;
            int delta = baseI - Math.abs(startPoints[i]);
            if (delta > 0) {
                checkpoints.add(endPoints[i] + delta);
                checkpoints.add(endPoints[i] - delta);
                checkpoints.add(endPoints[i]);
            }
        }
        long maxReduction = 0;
        for (int checkPoint : checkpoints) {
            maxReduction = Math.max(maxReduction, getReduction(startPoints, endPoints, checkPoint));
        }

        out.println(base - maxReduction);
        out.close();

    }
    public static long getReduction(int[] startPoints, int[] endPoints, int teleportEnd) {
        long totalReduction = 0;
        for (int i = 0; i < startPoints.length; i++) {
            int base = Math.abs(endPoints[i] - startPoints[i]);
            int travelByTeleport = Math.abs(startPoints[i]) + Math.abs(endPoints[i] - teleportEnd);
            int reduction = Math.max(0, base - travelByTeleport);
            totalReduction += reduction;
        }
        return totalReduction;
    }
}
