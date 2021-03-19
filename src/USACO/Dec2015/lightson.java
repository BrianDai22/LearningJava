package USACO.Dec2015;

import java.io.*;
import java.util.*;
public class lightson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("USACO.Dec2015.lightson.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2015.lightson.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        switches = new ArrayList[n][n];
        on = new boolean[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<Pair>();
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            switches[a][b].add(new Pair(c, d));
        }
        LinkedList<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0));
        on[0][0] = true;
        search(0, 0);
        int ret = 0;
        for(boolean[] row: on) {
            for(boolean col: row) {
                if(col) {
                    ret++;
                }
            }
        }
        pw.println(ret);
        pw.close();
    }

    private static boolean[][] on;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    private static ArrayList<Pair>[][] switches;

    private static void search(int x, int y) {
        if(isVisited(x, y)) return;
        visited[x][y] = true;
        for(Pair next: switches[x][y]) {
            if(!on[next.x][next.y]) {
                on[next.x][next.y] = true;
                if(hasVisitedNeighbor(next.x, next.y)) {
                    search(next.x, next.y);
                }
            }
        }
        for(int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(isOn(nx, ny)) {
                search(nx, ny);
            }
        }
    }


    private static boolean hasVisitedNeighbor(int x, int y) {
        for(int k = 0; k < dx.length; k++) {
            if(isOn(x + dx[k], y + dy[k]) && isVisited(x + dx[k], y + dy[k])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOn(int x, int y) {
        return x >= 0 && x < on.length && y >= 0 && y < on[x].length && on[x][y];
    }

    private static boolean isVisited(int x, int y) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[x].length && visited[x][y];
    }

    static class Pair {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}