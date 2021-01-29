package VPlanetCoding.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class auto {
    final public static int MAXLEN = 1000;

    public static HashMap<String, Integer> map;
    public static String[] words;

    public static void main(String[] args) throws Exception {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("baseball.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numWords = Integer.parseInt(st.nextToken());
        int numQueries = Integer.parseInt(st.nextToken());
        words = new String[numWords];
        map = new HashMap<>();
        for (int i = 0; i < numWords; i++) {
            words[i] = f.readLine();
            map.put(words[i], i + 1);
        }
        Arrays.sort(words);

        for (int i = 0; i < numQueries; i++) {
            st = new StringTokenizer(f.readLine());
            int rank = Integer.parseInt(st.nextToken());
            String partial = st.nextToken();
            out.println(solve(partial, rank));
        }
        out.close();
    }

    public static int solve(String partial, int rank) {
        char[] last = new char[MAXLEN + 1];
        Arrays.fill(last, 'z');
        for (int i = 0; i < partial.length(); i++) {
            last[i] = partial.charAt(i);
        }
        int start = binSearch(partial, 0, words.length);
        int end = binSearch(new String(last), 0, words.length);

        if (rank > end - start) {
            return -1;
        }
        return map.get(words[start + rank - 1]);
    }

    public static int binSearch(String partial, int low, int high) {

        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (partial.compareTo(words[mid]) < 0) {
                high = mid;
            } else {
                low = mid;
            }
            while (low < words.length && words[low].compareTo(partial) < 0) {
                low++;
            }
        }
        return low;

    }
}
