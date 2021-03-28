package USACOSILVER.Week8;

import java.io.*;
import java.util.*;

public class teleport4 {
    static int N;
    static HashMap<Integer, Integer> checkpoints = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("USACO.Feb2018.teleport.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2018.teleport.out")));
        N = Integer.parseInt(br.readLine());
        //key = index, value = slope change
        int[] startPoints = new int[N];
        int[] endPoints = new int[N];
        long base = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startPoints[i] = Integer.parseInt(st.nextToken());
            endPoints[i] = Integer.parseInt(st.nextToken());
            int baseI = Math.abs(startPoints[i]-endPoints[i]);
            base += baseI;
            int delta = baseI - Math.abs(startPoints[i]);
            if(delta > 0) {
                addCheckpoints(endPoints[i]-delta, -1, checkpoints);
                addCheckpoints(endPoints[i]-delta, 2, checkpoints);
                addCheckpoints(endPoints[i]-delta, -1, checkpoints);

            }
        }

        Integer[] indices = checkpoints.keySet().toArray(new Integer[checkpoints.size()]);
        Arrays.sort(indices);

        int slope = checkpoints.get(indices[0]);
        long currentDistance = base;
        long minDistance = base;

        for(int i = 1; i < checkpoints.size();i++) {
            int teleportEndDelta = indices[i] - 1;
            long distanceDelta = teleportEndDelta * slope;
            currentDistance += distanceDelta;
            minDistance = Math.min(minDistance, currentDistance);
            slope += checkpoints.get(indices[i]);
        }

        pw.println(minDistance);
        pw.close();
    }

    public static void addCheckpoints(int index, int slopeChange, HashMap<Integer, Integer> checkpoints) {
        if(checkpoints.containsKey(index)) {
            checkpoints.put(index, slopeChange - 1);
        } else {
            checkpoints.put(index, -1);
        }
    }

}

