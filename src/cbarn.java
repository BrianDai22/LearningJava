import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cbarn {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int rooms = Integer.parseInt(f.readLine());
        int[] cowsNeeded = new int[rooms];
        int[] cowsNeeded2 = new int[rooms * 2];

        //read in data
        for (int i = 0; i < rooms; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cowsNeeded[i] = Integer.parseInt(st.nextToken());
        }

        //make cowNeeded into a circle which is cowNeeded2
        for (int i = 0; i < rooms; i++) {
            cowsNeeded2[i] = cowsNeeded2[rooms + i] = cowsNeeded[i];
        }

        //System.out.println(Arrays.toString(cowsNeeded2));


        int total = 0;

        //making total the total amount of cows
        for(int i = 0; i < rooms; i++) {
            total += cowsNeeded[i];
        }

        int total2 = total;
        int answer = 1000000000;



        for(int i = 0; i < rooms; i++) {
            total = total2;
            int count = 0;
            for(int j = i + 1; j < cowsNeeded2.length; j++) {
                if(total - cowsNeeded2[j] <= 0) {
                    break;
                } else {
                    total = total - cowsNeeded2[j];
                    count += total;
                }
            }
            answer = Math.min(answer,count);
        }

        out.println(answer);
        out.close();
    }
}
