package VPlanetCoding.Week7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mountains {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week7.mountains.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week7.mountains.out")));

        int mountains = Integer.parseInt(f.readLine());

        int[][] coords = new int[mountains][2];

        for (int i = 0; i < mountains; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 2; j++) {
                coords[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(coords, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        //System.out.println(Arrays.deepToString(coords));

        ArrayList<int[]> rightMostAndLeftMost = new ArrayList<>();
        rightMostAndLeftMost.add(new int[]{coords[0][0] + coords[0][1], coords[0][0] - coords[0][1]});

        for (int i = 1; i < mountains; i++) {
            int[] rightAndLeftMostV2 = new int[]{coords[i][0] + coords[i][1], coords[i][0] - coords[i][1]};
            rightMostAndLeftMost.add(rightAndLeftMostV2);
            for (int[] x : rightMostAndLeftMost) {
                if ((rightAndLeftMostV2[0] < x[0] && rightAndLeftMostV2[1] >= x[1]) || (rightAndLeftMostV2[0] <= x[0]
                        && rightAndLeftMostV2[1] > x[1]) ||
                        (rightAndLeftMostV2[0] <= x[0] && rightAndLeftMostV2[1] >= x[1])) {

                    rightMostAndLeftMost.remove(rightAndLeftMostV2);
                    break;
                }
            }
        }

        out.println(rightMostAndLeftMost.size());
        out.close();

        /*
        for (int i = 0; i < VPlanetCoding.Week7.mountains; i++) {
            int x = coords[i][0];
            int xx = coords[i][0];
            int y = coords[i][1];
            ArrayList<int[]> rightMountainSlope = new ArrayList<>();
            ArrayList<int[]> leftMountainSlope = new ArrayList<>();
            while (y >= 0) {
                int[] rightSlope = new int[]{x, y};
                int[] leftSlope = new int[]{xx, y};
                rightMountainSlope.add(rightSlope);
                leftMountainSlope.add(leftSlope);
                x++;
                xx--;
                y--;
            }


            System.out.println(x);
            System.out.println(xx);
            System.out.println(y);


            for (int[] p : rightMountainSlope) {
                System.out.println(Arrays.toString(p));
            }



            System.out.println("OG: " + coords[i][0] + " " + coords[i][1]);

            boolean leftOrRight;

            for (int k = 0; k < VPlanetCoding.Week7.mountains; k++) {
                if (coords[k][0] == coords[i][0] && coords[k][1] == coords[i][1]) {
                    continue;
                }

                if(coords[k][0] > coords[i][0]) {
                    leftOrRight = true;
                } else {
                    leftOrRight = false;
                }

                if(leftOrRight) {
                    for (int[] arr : rightMountainSlope) {
                        if (arr[0] == coords[i][0] && arr[1] == coords[i][1]) {
                            continue;
                        }
                        if (coords[k][0] <= arr[0] && coords[k][1] <= arr[1]) {
                            visible--;
                            break;
                        }
                    }
                } else {
                    for (int[] arr : leftMountainSlope) {
                        if (arr[0] == coords[i][0] && arr[1] == coords[i][1]) {
                            continue;
                        }
                        if (coords[k][0] >= arr[0] && coords[k][1] <= arr[1]) {
                            visible--;
                            break;
                        }
                    }
                }
            }
        }
        */

    }
}
