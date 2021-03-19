package USACO.USOPEN2018;

import java.io.*;
import java.util.StringTokenizer;

class Cow {
    int id;
    int position;

    public Cow(int id, int position) {
        this.id = id;
        this.position = position;

    }
}

public class milkorder {

    static int nCows, M, nFixed;

    static Cow cows[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("USACO.USOPEN2018.milkorder.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("USACO.USOPEN2018.milkorder.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nCows = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nFixed = Integer.parseInt(st.nextToken());
        int[] order = new int[M + 1];
        cows = new Cow[nCows + 1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= nFixed; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }




    }

    /*
    private static boolean works() {

    }

     */

}
