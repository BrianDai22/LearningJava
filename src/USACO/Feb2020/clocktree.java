package USACO.Feb2020;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class clocktree {
    public static List<List<Integer>> graph;
    public static int[] visitTree;
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Feb2020.clocktree.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Feb2020.clocktree.out")));
        graph = new ArrayList<>();
        int rooms = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] amountPerClock = new int[rooms];
        for(int i = 0; i < rooms; i++) {
            amountPerClock[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < rooms; i++) {
            st = new StringTokenizer(f.readLine());
            int room1 = Integer.parseInt(st.nextToken());
            int room2 = Integer.parseInt(st.nextToken());
            graph.get(room1).add(room2);
            graph.get(room2).add(room1);
        }
        visitTree = new int[rooms];
        int answer = 0;

        out.println();
        out.close();
    }
    public static void visit(int subRoot, int root) {
        for(int roomID: graph.get(subRoot)) {
            if(roomID != root) {
                visitTree[roomID]++;
                visit(roomID, subRoot);
                visitTree[subRoot] += 12 - visitTree[roomID];
                visitTree[roomID] = 12;
                visitTree[subRoot] = (visitTree[subRoot] - 1) % 12 + 1;
            }
        }
        if(root >= 0) {
            visitTree[root]++;
        }
    }
}
