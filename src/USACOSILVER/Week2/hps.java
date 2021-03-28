package USACOSILVER.Week2;

import java.io.*;

public class hps {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int n = Integer.parseInt(f.readLine());
        int[] l = new int[n];
        int[] lReverse = new int[n];
        for(int i = 0; i < n; i++) {
            String s = f.readLine();
            if(s.equals("P")) {
                l[i] = 1;
            }
            else if(s.equals("S")) {
                l[i] = 2;
            }
            lReverse[l.length-1-i] = l[i];
        }
        int[][] matchPrefix = getMatch(l);
        int[][] matchSuffix = getMatch(lReverse);

        int ret = 0;
        for(int a = 0; a <= n; a++) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    ret = Math.max(ret, matchPrefix[i][a] + matchSuffix[j][n-a]);
                }
            }
        }
        out.println(ret);
        out.close();
    }

    public static int[][] getMatch(int[] l) {
        int[][] matches = new int[3][l.length+1];
        for(int i = 0; i < l.length; i++) {
            for(int j = 0; j < 3; j++) {
                matches[j][i+1] = matches[j][i];
            }
            matches[l[i]][i+1]++;
        }
        return matches;
    }
}
