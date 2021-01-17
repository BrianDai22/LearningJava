import java.io.*;
import java.util.StringTokenizer;

public class recPasture {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowvid.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowvid.out")));
        int amountOfCoords = Integer.parseInt(f.readLine());
        StringTokenizer st;
        int[][] coords = new int[amountOfCoords][2];
        int doableCombos = 2;
        for(int i = 0; i < amountOfCoords; i++) {
            st = new StringTokenizer(f.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < amountOfCoords; i++) {
            for(int j = 0; j < amountOfCoords; j++) {


            }
        }
    }
}
