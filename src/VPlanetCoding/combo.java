package VPlanetCoding;

import java.io.*;
import java.util.StringTokenizer;

public class combo {
    public static int maxDialValue;
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        maxDialValue = Integer.parseInt(f.readLine());
        int[] farmerCombo = new int[3];
        int[] masterCombo = new int[3];
        StringTokenizer st = new StringTokenizer(f.readLine());
        farmerCombo[0] = Integer.parseInt(st.nextToken());
        farmerCombo[1] = Integer.parseInt(st.nextToken());
        farmerCombo[2] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        masterCombo[0] = Integer.parseInt(st.nextToken());
        masterCombo[1] = Integer.parseInt(st.nextToken());
        masterCombo[2] = Integer.parseInt(st.nextToken());
        int possibleCombos = 0;
        for(int i = 1; i <= maxDialValue; i++) {
            for(int j = 1; j <= maxDialValue; j++) {
                for(int k = 1; k <= maxDialValue; k++) {
                    if(closeEnough(farmerCombo[0], farmerCombo[1], farmerCombo[2],i,j,k)
                            || closeEnough(masterCombo[0],masterCombo[1],masterCombo[2],i,j,k)) {
                        possibleCombos++;
                    }
                }
            }
        }
        out.println(possibleCombos);
        out.close();
    }
    public static boolean inRange(int lock, int attempt) {
        if(Math.abs(lock - attempt) <= 2) {
            return true;
        }
        return Math.abs(lock - attempt) >= maxDialValue - 2;
    }
    public static boolean closeEnough(int l1, int l2, int l3, int t1, int t2, int t3) {
        return inRange(l1,t1) && inRange(l2, t2) && inRange(l3,t3);
    }
}
