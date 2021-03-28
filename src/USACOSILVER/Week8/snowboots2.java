package USACOSILVER.Week8;

import java.io.*;
import java.util.StringTokenizer;

public class snowboots2 {
    public static int tileAmount;
    public static int bootAmount;
    public static boolean[][] visited;
    public static int[] tiles;
    public static int[] depthOfBoots;
    public static int[] agilityOfBoots;
    public static int answer;


    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week9.snowboots.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week9.snowboots.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        tileAmount = Integer.parseInt(st.nextToken());
        bootAmount = Integer.parseInt(st.nextToken());
        tiles = new int[tileAmount];
        depthOfBoots = new int[bootAmount];
        agilityOfBoots = new int[bootAmount];
        answer = Integer.MAX_VALUE;

        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < tileAmount; i++) {
            tiles[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < bootAmount; i++) {
            st = new StringTokenizer(f.readLine());
            depthOfBoots[i] = Integer.parseInt(st.nextToken());
            agilityOfBoots[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[tileAmount][bootAmount];
        visit(0,0);

        out.println(answer);
        out.close();
    }

    static void visit(int tileIndex, int bootIndex) {
        if(visited[tileIndex][bootIndex]) {
            return;
        }
        visited[tileIndex][bootIndex] = true;

        if(tileIndex == tiles.length - 1) {
            answer = Math.min(answer, bootIndex);
            return;
        }

        //travel to diff tile with same boots
        for(int nextTile = tileIndex + 1; nextTile < tileAmount
                && nextTile - tileIndex <= agilityOfBoots[bootIndex]; nextTile++) {
            if(depthOfBoots[bootIndex] >= tiles[nextTile]) {
                visit(nextTile, bootIndex);
            }
        }
        //change boots on the same tile
        for(int nextBoot = bootIndex + 1; nextBoot < bootAmount; nextBoot++) {
            if(depthOfBoots[nextBoot] >= tiles[tileIndex]) {
                visit(tileIndex, nextBoot);
            }
        }

    }
}
