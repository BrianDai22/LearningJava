
import java.io.*;

public class whereami2 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami2.out")));

        int length = Integer.parseInt(f.readLine());
        String word = f.readLine();
        int result = 0;
        for(int guess = 1; guess <= length; guess++) {
            boolean isGood = true;
            for(int i = 0; guess + i <= length; i++) {
                for(int j = 0; j < i; j++) {
                    if(word.substring(i, guess + i).equals(word.substring(j, guess + j))) {
                        isGood = false;
                    }
                }
            }
            if(isGood) {
                result = guess;
                break;
            }
        }

        out.println(result);
        out.close();


    }
}
