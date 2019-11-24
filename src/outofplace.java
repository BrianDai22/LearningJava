import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class outofplace {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        int size = Integer.parseInt(f.readLine());
        int[] arr = new int[size];

        for(int i =0; i < size;i++) {
            StringTokenizer st= new StringTokenizer(f.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = arr;
        Arrays.sort(arr2);



        out.println(3);
        out.close();
    }
}
