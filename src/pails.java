import java.io.*;
import java.util.StringTokenizer;

public class pails {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int smallPail = Integer.parseInt(st.nextToken());
        int bigPail = Integer.parseInt(st.nextToken());
        int mediumPail = Integer.parseInt(st.nextToken());
        int answer = 0;
        int temp = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;
        int temp5 = 0;

        temp = mediumPail - bigPail;
        temp4 = temp % smallPail;
        temp4 = mediumPail - temp4;

        System.out.println(temp4);

        temp2 = mediumPail % smallPail;
        temp2 = mediumPail - temp2;

        System.out.println(temp2);


        temp3 = mediumPail % bigPail;
        temp3 = mediumPail - temp3;

        System.out.println(temp3);

        temp5 = mediumPail % bigPail;
        temp5 = temp5 % smallPail;
        temp5 = mediumPail - temp5;

        System.out.println(temp5);

        answer = Math.max(temp4, Math.max(temp2, temp3));
        answer = Math.max(answer, temp5);












        out.println(answer);
        out.close();

    }
}
