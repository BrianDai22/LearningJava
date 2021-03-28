package USACOSILVER.Week9;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class snowboots {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week9.snowboots.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week9.snowboots.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int tiles = Integer.parseInt(st.nextToken());
        int pairs = Integer.parseInt(st.nextToken());
        int[] tileData = new int[tiles];
        Queue<Integer> depthOrder = new LinkedList<>();
        Queue<Integer> stepOrder = new LinkedList<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < tiles; i++) {
            tileData[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < pairs; i++) {
            st = new StringTokenizer(f.readLine());
            depthOrder.add(Integer.parseInt(st.nextToken()));
            stepOrder.add(Integer.parseInt(st.nextToken()));
        }

        int discardedAmount = 0;
        int currentStep = 0;
        boolean stop = false;
        while (!depthOrder.isEmpty() || !stepOrder.isEmpty()) {
            for (int j = currentStep; j < tiles; j++) {
                int depthAmount = depthOrder.peek();
                int stepAmount = stepOrder.peek();
                boolean isGood = false;
                if(currentStep + stepAmount > tiles) {
                    stop = true;
                    break;
                }
                for (int k = currentStep + stepAmount; k > currentStep; k--) {
                    if (depthAmount >= tileData[k]) {
                        isGood = true;
                        currentStep = k;
                    }
                }
                if(!isGood) {
                    discardedAmount++;
                    depthOrder.poll();
                    stepOrder.poll();
                }
            }
            if(stop) {
                break;
            }
        }
        out.println(discardedAmount);
        out.close();
    }
}
