import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class piggyback {

    public static int fields;
    public static ArrayList[] pathData;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("piggyback.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("piggyback.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int bessieEnergy = Integer.parseInt(st.nextToken());
        int elsieEnergy = Integer.parseInt(st.nextToken());
        int piggyEnergy = Integer.parseInt(st.nextToken());

        fields = Integer.parseInt(st.nextToken());
        pathData = new ArrayList[fields];
        for(int i = 0; i < fields; i++) {
            pathData[i] = new ArrayList<Integer>();
        }

        int connections = Integer.parseInt(st.nextToken());

        for(int i = 0; i < connections; i++) {
            st = new StringTokenizer(f.readLine());
            int field1 = Integer.parseInt(st.nextToken())-1;
            int field2 = Integer.parseInt(st.nextToken())-1;
            pathData[field1].add(field2);
            pathData[field2].add(field1);
        }

        int[] bessieFastestPath = BFS(0);
        int[] elsieFastestPath = BFS(1);
        int[] piggyFastestPath = BFS(fields-1);

        //control answer no piggy back ride only individual
        int answer = (bessieFastestPath[fields-1] * bessieEnergy) + (elsieFastestPath[fields-1] * elsieEnergy);

        for(int i = 0; i < fields-1; i++) {
            //if no paths are avalable skip
            if(bessieFastestPath[i] == -1 || elsieFastestPath[i] == -1 || piggyFastestPath[i] == -1) {
                continue;
            }
            //use piggy back and check if less energy is used
            answer = Math.min(answer, (bessieFastestPath[i] * bessieEnergy) +
                    (elsieFastestPath[i] * elsieEnergy) + (piggyFastestPath[i] * piggyEnergy));
        }

        System.out.println(Arrays.toString(bessieFastestPath));
        System.out.println(Arrays.toString(pathData));
        out.println(answer);
        out.close();
    }

    //distance to each field
    public static int[] BFS(int startingField) {
        int[] distanceToNeighboringFields = new int[fields];
        Arrays.fill(distanceToNeighboringFields, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingField);

        while(!queue.isEmpty()) {
            int currentField = queue.poll();
            for(Integer neighborField: (ArrayList<Integer>) pathData[currentField]) {
                if(distanceToNeighboringFields[neighborField] == -1) {
                    distanceToNeighboringFields[neighborField] = distanceToNeighboringFields[currentField] + 1;
                    queue.add(neighborField);
                }
            }
        }
        return distanceToNeighboringFields;
    }
}
