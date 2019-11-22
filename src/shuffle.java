import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shuffle {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        int numCows = Integer.parseInt(f.readLine());
        System.out.println(numCows);
        int[] order = new int[numCows+1];
        int[] newOrder = new int[numCows+1];
        int[] afterCows= new int[numCows+1];
        int[] beforeCows = new int[numCows+1];

        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 1; i <= numCows; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(order));
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        for(int i = 1; i <= numCows; i++) {
            afterCows[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(Arrays.toString(afterCows));

        /*
        int index = 0;
        for(int i = order.length-1; i >= 0; i--) {
            newOrder[index] = order[i];
            index++;
        }
         */
        //System.out.println(Arrays.toString(newOrder));
        for(int i = 1; i <= numCows; i++) {
            int temp = order[i];
            newOrder[temp] = i;
        }
        System.out.println(Arrays.toString(newOrder));
        for (int i = 1; i <= numCows; i++) {
            int position = i;
            for (int j = 1; j <= 3; j++) {
                position = newOrder[position];
            }
            beforeCows[position] = afterCows[i];
        }
        System.out.println(Arrays.toString(beforeCows));

        for(int i = 1; i <= numCows; i++) {
                out.println(beforeCows[i]);
        }
        out.close();

    }
}
