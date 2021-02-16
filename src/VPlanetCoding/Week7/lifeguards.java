package VPlanetCoding.Week7;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week7.lifeguards.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week7.lifeguards.out")));
    /*
        int num = Integer.parseInt(f.readLine());
        int[] start = new int[num];
        int[] end = new int[num];

        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i = 0; i < num; i++) {
            answer = Math.max(answer, getConveredIntervals(start,end,i));
        }
        out.println(answer);
        out.close();
    }

    public static int getConveredIntervals(int[] start, int[] end, int skip) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < start.length; i++) {
            if(i == skip) {
                continue;
            }
            for(int j = start[i]; j < end[i]; j++) {
                set.add(j);
            }
        }

        return set.size();
    }

     */
        int n = Integer.parseInt(f.readLine());
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int[] numCover = new int[1000];
        for(int i = 0; i < n; i++) {
            for(int t = start[i]; t < end[i]; t++) {
                numCover[t]++;
            }
        }
        int maxCover = 0;
        for(int i = 0; i < n; i++) {
            for(int t = start[i]; t < end[i]; t++) {
                numCover[t]--;
            }
            int covered = 0;
            for(int t = 0; t < 1000; t++) {
                if(numCover[t] > 0) {
                    covered++;
                }
            }
            maxCover = Math.max(maxCover, covered);
            for(int t = start[i]; t < end[i]; t++) {
                numCover[t]++;
            }
        }
        out.println(maxCover);
        out.close();
    }
}
