import java.io.*;
import java.util.*;

public class cowvid {
    public static List<List<Integer>> graph;
    public static int farms;
    public static Set<Integer> visited;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        //BufferedReader f = new BufferedReader(new FileReader("cowvid.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // input file name goes above
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowvid.out")));
        farms = Integer.parseInt(f.readLine());
        graph = new ArrayList<>();
        visited = new HashSet<>();
        for (int i = 0; i < farms; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < farms - 1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int farm1 = Integer.parseInt(st.nextToken()) - 1;
            int farm2 = Integer.parseInt(st.nextToken()) - 1;
            graph.get(farm1).add(farm2);
        }
        int days = 0;
        int farm = 1;
        while(farm <= graph.get(0).size()) {
            farm *= 2;
            days++;
        }
        days += farms-1;
        System.out.println(days);
        /*
        out.println();
        out.close();
         */
    }
    /*
    public static int BFS(int start) {
        int[] cowsPerFarm = new int[farms];
        cowsPerFarm[0] = 1;
        int days = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int currentFarm = q.poll();
            while (cowsPerFarm[currentFarm] <= graph.get(currentFarm).size()) {
                cowsPerFarm[currentFarm] *= 2;
                days++;
            }
            for (Integer neighborFarm : graph.get(currentFarm)) {
                if(visited.contains(neighborFarm)) {
                    continue;
                }
                if (cowsPerFarm[neighborFarm] == 0) {
                    cowsPerFarm[currentFarm]--;
                    cowsPerFarm[neighborFarm]++;
                    days++;
                }
                q.add(neighborFarm);
                visited.add(neighborFarm);
            }
        }
        return days;
    }

     */
}
