import java.io.*;
import java.util.*;

public class piggyback2 {

    public static Map<Integer, ArrayList<Integer>> data = new HashMap<>();
    public static int fields;
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("piggyback.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("piggyback.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int bessie = Integer.parseInt(st.nextToken());
        int elsie = Integer.parseInt(st.nextToken());
        int piggy = Integer.parseInt(st.nextToken());
        fields = Integer.parseInt(st.nextToken());
        int connections = Integer.parseInt(st.nextToken());
        for(int i = 0; i < connections; i++) {
            st = new StringTokenizer(f.readLine());
            int field1 = Integer.parseInt(st.nextToken())-1;
            int field2 = Integer.parseInt(st.nextToken())-1;

            data.computeIfAbsent(field1, key -> new ArrayList<>());
            data.get(field1).add(field2);

            data.computeIfAbsent(field2, key -> new ArrayList<>());
            data.get(field2).add(field1);
        }

        int[] bessiePaths = BFS(0);
        int[] elsiePaths = BFS(1);
        int[] endPaths = BFS(fields-1);
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < fields; i++) {
            if(bessiePaths[i] == -1 || elsiePaths[i] == -1 || endPaths[i] == -1) {
                continue;
            }
            answer = Math.min(answer, bessie * bessiePaths[i]
                    + elsie * elsiePaths[i] + piggy * endPaths[i]);
        }

        out.println(answer);
        out.close();
    }
    public static int[] BFS(int start) {

        int[] distance = new int[fields];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        for(int i = 0; i < fields; i++) {
            int currentField = q.poll();
            for(Integer neighborField: data.get(currentField)) {
                if(distance[neighborField] == -1) {
                    distance[neighborField] = distance[currentField] + 1;
                    q.add(neighborField);
                }
            }
        }

        return distance;
    }

}


/*
            if(!data.containsKey(field1)) {
                data.put(field1, new ArrayList<>());
            } else {
                data.get(field1).add(field2);
            }

            if(!data.containsKey(field2)) {
                data.put(field2, new ArrayList<>());
            } else {
                data.get(field2).add(field1);
            }
             */