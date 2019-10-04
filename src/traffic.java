import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class traffic {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

        int miles = Integer.parseInt(f.readLine());
        String[] ramps = new String[miles];
        int[] minCars = new int[miles];
        int[] maxCars = new int[miles];

        for(int i = 0 ; i < miles; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            ramps[i] = st.nextToken();
            minCars[i] = Integer.parseInt(st.nextToken());
            maxCars[i] = Integer.parseInt(st.nextToken());

        }

        int finalMin = -1;
        int finalMax = 999999;
        int intitalMin = -1;
        int intitalMax = 999999;
        for(int i = 0; i < miles; i++) {
            /*
            if(ramps[i].equals("none")) {
                //get maximum of finalmin and min car[i] = finalmin
                //get minimum of final max and max car[i] = finalmax
                finalMin = Math.max(finalMin, minCars[i]);
                finalMax = Math.min(finalMax, maxCars[i]);
            } else if(ramps[i].equals("on")){
                //add min car[i] to final min
                // add max car[i] to final max
                finalMin = minCars[i] + finalMin;
                finalMax = maxCars[i] + finalMax;
            } else if(ramps[i].equals("off")) {
                //subtract max car[i] from final min
                //subtract min car[i] from final max
                finalMin = finalMin - maxCars[i];
                finalMax = finalMax - minCars[i];
            }
            */
            switch (ramps[i]) {
                case ("none"):
                    finalMin = Math.max(finalMin, minCars[i]);
                    finalMax = Math.min(finalMax, maxCars[i]);
                    break;
                case ("on"):
                    finalMin = minCars[i] + finalMin;
                    finalMax = maxCars[i] + finalMax;
                    break;
                case("off") :
                    finalMin = finalMin - maxCars[i];
                    finalMax = finalMax - minCars[i];
                    break;

            }


        }

        for(int i = miles-1; i >= 0; i--) {
            switch (ramps[i]) {
                case ("none"):
                    intitalMin = Math.max(intitalMin, minCars[i]);
                    intitalMax = Math.min(intitalMax, maxCars[i]);
                    break;
                case ("on"):
                    intitalMin = intitalMin - maxCars[i];
                    intitalMax = intitalMax - minCars[i];
                    break;
                case("off") :
                    intitalMin = minCars[i] + intitalMin;
                    intitalMax = maxCars[i] + intitalMax;
                    break;

            }
        }



        System.out.println(Math.max(intitalMin , 0) + " " + Math.max(intitalMax,0));
        System.out.println(Math.max(finalMin, 0) + " " + Math.max(finalMax,0));


        //System.out.println(Arrays.toString(ramps));
        //System.out.println(Arrays.toString(minCars));
        //System.out.println(Arrays.toString(maxCars));

        out.println();
        out.close();
    }
}
