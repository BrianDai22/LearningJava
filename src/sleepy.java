import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(arr));
        pw.println();
        pw.close();

    }
}
