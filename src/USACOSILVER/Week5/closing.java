package USACOSILVER.Week5;

import java.io.*;
import java.util.*;

public class closing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<LinkedList<Integer>> connected = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        LinkedList<Integer> notVisited = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            connected.add(new LinkedList<>());
        }
        for (int i = 1; i <= N; i++) {
            notVisited.add(i);
        }
        for (int i = 0; i < M; i++) { 
            st = new StringTokenizer(f.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            connected.get(i1).add(i2);
            connected.get(i2).add(i1);
        }
        if (DFS(connected, new boolean[N + 1], notVisited.get(0), 1, visited) == N) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        for (int i = 0; i < N - 1; i++) {
            int ignore = Integer.parseInt(f.readLine());
            visited[ignore] = true;
            notVisited.remove(notVisited.indexOf(ignore)); 
            if (DFS(connected, new boolean[N + 1], notVisited.get(0), 1, visited) == N - (i + 1)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
    }

    private static int DFS(ArrayList<LinkedList<Integer>> connected, boolean[] visited, int v, int count, boolean[] visited2) {
        visited[v] = true; 
        for (int w : connected.get(v)) { 
            if (!visited[w] && !visited2[w]) {
                count = DFS(connected, visited, w, ++count, visited);
            }
        }
        return count;
    }
}