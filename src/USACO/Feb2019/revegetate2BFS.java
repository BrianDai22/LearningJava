package USACO.Feb2019;

import java.io.*;
import java.util.*;

public class revegetate2BFS {
        public static int[] pastures;
        public static Map<Integer, Set<Integer>> same = new HashMap<>();
        public static Map<Integer, Set<Integer>> dif = new HashMap<>();
        public static boolean impossible;

        public static void main(String[] args) throws IOException {
            BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week6.revegetate2.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week6.revegetate2.out")));

            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int numConnected = 0;
            pastures = new int[n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                String s = st.nextToken();
                int field1 = Integer.parseInt(st.nextToken());
                int field2 = Integer.parseInt(st.nextToken());
                if (s.equals("S")) {
                    connectPasture(same, field1, field2);
                    connectPasture(same, field2, field1);
                } else {
                    connectPasture(dif, field1, field2);
                    connectPasture(dif, field2, field1);
                }
            }
            for (int i = 1; i <= n; i++) {
                if (pastures[i] == 0) {
                    visit(i, 1);
                    numConnected++;
                    if (impossible) {
                        out.println(0);
                        out.close();
                        return;
                    }
                }
            }
            out.print(1);
            for (int i = 0; i < numConnected; i++) {
                out.print(0);
            }
            out.close();
        }

        public static void connectPasture(Map<Integer, Set<Integer>> pastureMap, int field1, int field2) {
            if (!pastureMap.containsKey(field1)) {
                pastureMap.put(field1, new HashSet<>());
            }
            pastureMap.get(field1).add(field2);
        }

        public static void visit(int pastureId, int grassType) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(pastureId);

            pastures[pastureId] = grassType;

            while (!q.isEmpty()) {
                int currentPasture = q.poll();

                if (same.containsKey(currentPasture)) {
                    for (int newPasture : same.get(currentPasture)) {
                        if (pastures[newPasture] == 0) {
                            q.offer(newPasture);
                            pastures[newPasture] = pastures[currentPasture];
                        } else if (pastures[newPasture] != pastures[currentPasture]) {
                            impossible = true;
                            return;
                        }
                    }
                }

                if (dif.containsKey(currentPasture)) {
                    for (int newPasture : dif.get(currentPasture)) {
                        if (pastures[newPasture] == 0) {
                            q.offer(newPasture);
                            pastures[newPasture] = 3 - pastures[currentPasture];
                        } else if (pastures[newPasture] == pastures[currentPasture]) {
                            impossible = true;
                            return;
                        }
                    }
                }

            }
        }

}

/*

 */