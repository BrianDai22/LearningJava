import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class noTimeToPaint {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("notimetopaint.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notimetopaint.out")));
        //UNCOMMENT WHEN SUBMIT TO USACO WEBSITE BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int amountOfSegments = Integer.parseInt(st.nextToken());
        int amountOfGaps = Integer.parseInt(st.nextToken());
        char[] originalFence = f.readLine().toCharArray();
        ArrayList<char[]> fences = new ArrayList<>();
        char[] colors = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for(int i = 0; i < amountOfGaps; i++) {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            fences.add(originalFence.clone());
            for(int j = start; j < end; j++) {
                fences.get(i)[j] = '0';
            }
        }
        int count = 0;
        for(char[] x: fences) {
            for(int i = 0; i < colors.length; i++) {

            }
        }
        out.println();
        out.close();
    }
}
