import java.io.*;
import java.util.Arrays;

public class breedflip {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        int length = Integer.parseInt(f.readLine());
        String a = f.readLine();
        String b = f.readLine();
        int[] freq = new int[length];
        for(int i = 0; i < length; i++) {
            if(b.charAt(i) != a.charAt(i)) {
                freq[i] = 1;
            }
        }
        System.out.println(Arrays.toString(freq));

        int count = 0;
        for(int i = 0; i < length; i++) {
            if(freq[i] == 1) {
                if(freq[i + 1] != 1) {
                    count++;
                }
            }
        }

        out.println(count);
        out.close();
    }
}
