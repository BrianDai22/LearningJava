package VPlanetCoding.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class maxCross {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        String s = f.readLine();
        boolean[] seen = new boolean[26];
        boolean[][] cross = new boolean[26][26];

        // Go through the string.
        for (int i = 0; i < s.length(); i++) {
            if (seen[s.charAt(i) - 'A']) {
                continue;
            }
            seen[s.charAt(i) - 'A'] = true;
            int[] freq = new int[26];
            int j = i + 1;
            while (s.charAt(j) != s.charAt(i)) {
                freq[s.charAt(j) - 'A']++;
                j++;
            }
            for (int k = 0; k < 26; k++) {
                if (freq[k] == 1) {
                    int id = s.charAt(i) - 'A';
                    cross[Math.min(k, id)][Math.max(k, id)] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (cross[i][j])
                    res++;
            }
        }
        out.println(res);
        out.close();
    }
}
/*

 */